package person.until;

/**
 * @author: Mr.He
 * @create: 2022-04-28 13:59
 * @description: 雪花算法实现
 **/
public class SnowflakeIdWorker {
    /**
     * 开始时间戳（2015-01-01）
     */
    private final long twepoch = 1420041600000L;
    /**
     * 机器id所占的位数
     */
    private final long workIdBits = 5L;
    /**
     * 数据标识ID所占的位数
     */
    private final long datacenterIdBits = 5L;
    /**
     * 支持的最大机器id,结果是31（这个位移算法可以很快的计算出几位二进制数所能代表的最大十进制数）
     */
    private final long maxWorkerId = -1L ^ (-1L << workIdBits);
    /**
     * 支持最大的数据标识id，结果是31
     */
    private final long maxDatacentterId = -1L ^ (-1L << datacenterIdBits);
    /**
     * 序列在id中占的位数
     */
    private final long sequenceBits = 12L;
    /**
     * 机器ID向左移12位
     */
    private final long workIdShift = sequenceBits;
    /**
     * 数据标识id向左移17位（12 + 5）
     */
    private final long datacenterShift = sequenceBits + workIdBits;
    /**
     * 时间戳向左移22位（5 + 5 + 12）
     */
    private final long timestampLeftShift = sequenceBits + workIdBits + datacenterIdBits;
    /**
     * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);
    /**
     * 工作机器ID(0-31)
     */
    private long workerId;
    /**
     * 数据中心ID(0-31)
     */
    private long datacenterId;
    /**
     * 毫秒内序列（0-4095）
     */
    private long sequence = 0L;
    /**
     * 上次生成ID的时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * 构造函数
     * @param workerId 工作ID（0-31）
     * @param datacenterId 数据中心ID（0-31）
     */
    public SnowflakeIdWorker(long workerId,long datacenterId){
        if (workerId > maxWorkerId || workerId < 0){
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacentterId || datacenterId < 0){
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacentterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    /**
     * 获取下一个ID（该方法多线程安全）
     * @return SnowflakeId
     */
    public  synchronized long nextId() {
        long timestamp = timeGen();
        // 如果当前时间小于上一次ID生成的时间，说明系统时钟回退过这个时候应当抛异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 毫秒内序列列溢出
            if (sequence == 0) {
                //阻塞到下一毫秒，获得新的时间戳
                timestamp = tilNextMills(lastTimestamp);
            }
        }
        // 时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }
        //上次生成ID的时间戳
        lastTimestamp = timestamp;
        // 移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) //
                | (datacenterId << datacenterShift) //
                | (workerId << workIdShift) //
                | sequence;
    }

    /**
     * 阻塞到下一毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间戳
     * @return  当前时间戳
     */
    public long tilNextMills(long lastTimestamp){
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp){
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return  当前时间（毫秒）
     */
    protected long timeGen(){
        return System.currentTimeMillis();
    }

    public static void main(String[] args) throws InterruptedException {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0,0);
        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            Thread.sleep(1);
            System.out.println(id);
        }
    }
}

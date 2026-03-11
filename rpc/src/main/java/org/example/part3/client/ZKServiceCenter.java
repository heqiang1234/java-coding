package org.example.part3.client;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/11 06:57
 * @Description: ZK注册
 */
public class ZKServiceCenter implements ServiceCenter {
    // curatoe 提供zookeeper客户端
    private CuratorFramework client;
    // zookeeper 根路径节点
    private static final String ROOT_PATH = "MyRPC1";

    public ZKServiceCenter() {
        RetryPolicy policy = new ExponentialBackoffRetry(1000, 3);
        // zookeeper的地址固定，不管是服务提供者还是消费者都要与之建立连接
        // sessionTimeoutMs 与zoo.cfg中的tickTime有关系
        // zk还会根据minSessionTimeOUT与maxSessionTimeout两个参数重新调整
        // 使用心跳监听状态
        this.client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").sessionTimeoutMs(40000).
                retryPolicy(policy).namespace(ROOT_PATH).build();
        this.client.start();
        System.out.println("zookeeper 连接成功");
    }

    @Override
    public InetSocketAddress serviceDecovery(String serviceName) {
        try {
            // 获取服务名对应路径下的所有子节点，子节点通常保存服务实例的地址
            List<String> strings = client.getChildren().forPath("/" + serviceName);
            // 这里默认用的第一个，后面加负载均衡
            String string = strings.get(0);
            // 将子节点字符串（IP：port格式）解析成InetSocketAddress，便于服务端通信
            return parseAddress(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getServiceAdress(InetSocketAddress serverAddress) {
        return serverAddress.getHostName() + ":" + serverAddress.getPort();
    }

    // 字符串解析成地址，“127.0.0.1：2181”，解析成 address= 127.0.0.1 port = 2181
    private InetSocketAddress parseAddress(String address) {
        String[] split = address.split(":");
        return new InetSocketAddress(split[0], Integer.parseInt(split[1]));
    }
}

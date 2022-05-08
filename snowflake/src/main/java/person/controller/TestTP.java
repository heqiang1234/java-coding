package person.controller;

import person.until.MethodInfo;

import java.util.*;

/**
 * @author: Mr.He
 * @create: 2022-04-28 15:53
 * @description: 测试TP
 **/
public class TestTP {
    // rate 代表百分比 90 传入 0.9 即可  99 就是 0.99
    private static long  getTP(List<MethodInfo> methodInfos, double  rate){
        // System.out.println("getTp");
        // 构建一个临时数组保存 满足1一分钟之内的数据
        List<MethodInfo>  sortInfo = new ArrayList<>();
        // 计算最近一分钟的TP90 和 TP99
        long  endTime = System.currentTimeMillis();
        long  startTime = System.currentTimeMillis() - 60000;
        // 遍历列表集合
        int  length = methodInfos.size();
        for (int i=0;i<length;i++){
            //System.out.println("#######");
            MethodInfo  methodInfo = methodInfos.get(i);
            if (methodInfo.getEndTimes() >= startTime && methodInfo.getEndTimes() <= endTime){
                sortInfo.add(methodInfo);
            }
        }
        sortInfo.sort(new Comparator<MethodInfo>() { //正序排列
            @Override
            public int compare(MethodInfo o1, MethodInfo o2) {
                if(o1.getTimes() > o2.getTimes()){
                    return  1;
                }else if(o1.getTimes() < o2.getTimes()){
                    return -1;
                }else{
                    return  0;
                }

            }
        });
        int  index = (int)(sortInfo.size() * rate);//直接取整

        return sortInfo.get(index).getTimes();
    }

    public static void main(String[] args) {
        HashMap<String,List<MethodInfo>> methodTimes = new HashMap<>();
        //methodTimes.put("test1",new )
        for(Map.Entry<String, List<MethodInfo>> methodInfos : methodTimes.entrySet()){
            System.out.println(methodInfos.getKey() +"的TP90:" + getTP(methodInfos.getValue(),0.9) + "毫秒,"
                    + "TP99:" + getTP(methodInfos.getValue(),0.99)+ "毫秒" );
        }
    }
}

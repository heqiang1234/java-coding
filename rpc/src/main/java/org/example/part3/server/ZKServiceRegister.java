package org.example.part3.server;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.net.InetSocketAddress;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/11 07:24
 * @Description: 服务注册实现类
 */
public class ZKServiceRegister implements ServiceRegister {
    private CuratorFramework client;

    private static final String ROOT_PATH = "MyRPC1";

    public ZKServiceRegister() {
        RetryPolicy retry = new ExponentialBackoffRetry(1000, 3);

        this.client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").retryPolicy(retry).sessionTimeoutMs(40000).namespace(ROOT_PATH).build();

        this.client.start();

        System.out.println("zookeeper 连接成功");


    }

    @Override
    public void register(String name, InetSocketAddress socketAddress) {
        try {
            // serviceName创建成永久节点，服务提供者下线，不删服务名，只删地址
            if (client.checkExists().forPath("/" + name) == null){
                client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/" + name);
            }
            // 路径地址，一个/代表一个节点
            String path = "/" + name + "/" + getServiceAdress(socketAddress);
            // 临时节点，服务器下线就删除节点
            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path);
        } catch (Exception e) {
            System.out.println("服务已下线");
            throw new RuntimeException(e);
        }
    }

    private String getServiceAdress(InetSocketAddress socketAddress) {

        return socketAddress.getHostName() + ":" + socketAddress.getPort();
    }

    private InetSocketAddress praseAdress(String s) {
        String[] split = s.split(":");
        return new InetSocketAddress(split[0], Integer.parseInt(split[1]));
    }
}

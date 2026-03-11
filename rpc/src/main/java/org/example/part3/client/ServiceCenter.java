package org.example.part3.client;

import java.net.InetSocketAddress;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/11 06:56
 * @Description: ZK注册接口
 */
public interface ServiceCenter {

    InetSocketAddress serviceDecovery(String serviceName);
}

package org.example.part3.server;

import java.net.InetSocketAddress;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/11 07:23
 * @Description: 服务注册
 */
public interface ServiceRegister {
    // 注册：保存服务与地址
    void register(String name, InetSocketAddress socketAddress);
}

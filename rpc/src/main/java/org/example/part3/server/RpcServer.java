package org.example.part3.server;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/9 22:29
 * @Description: rpc服务器
 */
public interface RpcServer {
    void start(int port);
    void stop();
}

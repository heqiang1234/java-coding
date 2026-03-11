package org.example.part3;

import org.example.part3.common.ServicePrivider;
import org.example.part3.common.UserServiceImpl;
import org.example.part3.server.NettyRpcServer;
import org.example.part3.server.RpcServer;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/10 07:25
 * @Description: 测试服务器
 */
public class TestServer {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        ServicePrivider servicePrivider = new ServicePrivider("127.0.0.1",9988);

        servicePrivider.provideServiceInterface(userService);

        RpcServer rpcServer = new NettyRpcServer(servicePrivider);

        rpcServer.start(9988);
    }
}

package org.example.part2;

import org.example.part2.common.ServicePrivider;
import org.example.part2.common.UserServiceImpl;
import org.example.part2.server.NettyRpcServer;
import org.example.part2.server.RpcServer;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/10 07:25
 * @Description: 测试服务器
 */
public class TestServer {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        ServicePrivider servicePrivider = new ServicePrivider();

        servicePrivider.provideServiceInterface(userService);

        RpcServer rpcServer = new NettyRpcServer(servicePrivider);

        rpcServer.start(8088);
    }
}

package org.example.part2;

import org.example.part2.common.ClientProxy;
import org.example.part2.common.UserService;
import org.example.part2.common.pojo.User;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/10 07:24
 * @Description: 客户端启动
 */
public class TestClient {
    public static void main(String[] args) {
        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8088, 1);
        UserService service = clientProxy.getProxy(UserService.class);


        Integer hq = service.insertUser(new User("hq", 1, false));
        System.out.println(hq.toString());
        System.out.println("Hello world!");

        User userByUserId = service.getUserByUserId(1);
        System.out.println(userByUserId.toString());
    }
}

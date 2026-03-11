package org.example.part3.common;

import org.example.part3.server.ServiceRegister;
import org.example.part3.server.ZKServiceRegister;

import java.net.InetSocketAddress;
import java.util.HashMap;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/9 22:41
 * @Description: 服务代理
 */
public class ServicePrivider {

    private int port;
    private String adderss;
    private HashMap<String, Object> interfaceProvider;

    // 注册实现类
    private ServiceRegister serviceRegister;

    public ServicePrivider(HashMap<String, Object> interfaceProvider) {
        this.interfaceProvider = interfaceProvider;
    }

    public ServicePrivider() {
        this.interfaceProvider = new HashMap<>();
    }

    public ServicePrivider(String adress, int port) {
        this.adderss = adress;
        this.port = port;
        this.interfaceProvider = new HashMap<>();
        this.serviceRegister = new ZKServiceRegister();
    }

    public void provideServiceInterface(Object service) {
        String name = service.getClass().getName();
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for (Class<?> clazz : interfaces) {
            interfaceProvider.put(clazz.getName(), service);

            serviceRegister.register(clazz.getName(), new InetSocketAddress(adderss, port));
        }
    }

    public Object getService(String name) {
        return interfaceProvider.get(name);
    }
}

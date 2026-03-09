package org.example.part2.common;

import java.util.HashMap;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/9 22:41
 * @Description: 服务代理
 */
public class ServicePrivider {

    private HashMap<String, Object> interfaceProvider;

    public ServicePrivider(HashMap<String, Object> interfaceProvider) {
        this.interfaceProvider = interfaceProvider;
    }

    public void provideServiceInterface(Object service) {
        String name = service.getClass().getName();
        Class<?>[] interfaces = service.getClass().getInterfaces();

        for (Class<?> clazz : interfaces) {
            interfaceProvider.put(clazz.getName(), service);
        }
    }

    public Object getService(String name) {
        return interfaceProvider.get(name);
    }
}

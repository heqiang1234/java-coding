package org.example.part3.common;

import lombok.AllArgsConstructor;
import org.example.part3.client.netty.NettyRpcClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/9 20:20
 * @Description: 客户端
 */
@AllArgsConstructor
public class ClientProxy implements InvocationHandler {

    private String host;
    private int port;

    private RpcClient rpcClient;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = RpcRequest.builder().
                interfaceName(method.getDeclaringClass().getName()).
                methodName(method.getName()).
                params(args).
                paramType(method.getParameterTypes()).build();
        // 传输数据
        System.out.println("invoke加强");
        RpcResponse response = rpcClient.sendRequest(request);
        return response.getData();
    }

    public ClientProxy(String host, int port, int choose) {
        switch (choose) {
            case 0:
            case 1:
            default:
                rpcClient = new NettyRpcClient(host, port);
        }
    }

    public ClientProxy() {
        rpcClient = new NettyRpcClient();
    }

    public <T> T getProxy(Class<T> clazz) {
        // 使用Proxy.newProxyInstance动态创建一个代理对象，传入类加载器、需要代理的接口和调用处理程序
        Object object = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T) object;
    }


}

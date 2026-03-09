package org.example.part2.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.example.part2.common.RpcRequest;
import org.example.part2.common.RpcResponse;
import org.example.part2.common.ServicePrivider;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/5 07:15
 * @Description: 服务器处理器
 */
public class NettyServerHanlder extends SimpleChannelInboundHandler<RpcRequest> {

    private ServicePrivider servicePrivider;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcRequest rpcRequest) throws Exception {
//        AttributeKey<Object> key = AttributeKey.valueOf("RpcRequest");
//        channelHandlerContext.channel().attr(key).set(rpcRequest);
//        channelHandlerContext.channel().close();
        RpcResponse response = getResponse(rpcRequest);
        channelHandlerContext.writeAndFlush(response);
        channelHandlerContext.close().sync();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        super.exceptionCaught(ctx, cause);
    }

    public RpcResponse getResponse(RpcRequest request) {
        // 得到服务名
        String interfaceName = request.getInterfaceName();
        // 得到服务端相应服务实现类
        Object service = servicePrivider.getService(interfaceName);
        //反射调用方式
        Method method = null;
        try {
            method = service.getClass().getMethod(request.getMethodName(), request.getParamType());
            Object invoke = method.invoke(service, request.getParams());
            return RpcResponse.success(invoke);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("方法执行错误");
            return RpcResponse.fail();
        }
    }
}

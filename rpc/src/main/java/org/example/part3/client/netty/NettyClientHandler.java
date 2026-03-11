package org.example.part3.client.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;
import org.example.part3.common.RpcResponse;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/4 20:46
 * @Description: 自定义通道处理器
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse rpcResponse) throws Exception {
        AttributeKey<Object> key = AttributeKey.valueOf("RpcResponse");
        channelHandlerContext.channel().attr(key).set(rpcResponse);
        channelHandlerContext.channel().close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        super.exceptionCaught(ctx, cause);
    }
}

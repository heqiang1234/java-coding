package com.example.netty.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.net.InetAddress;

/**
 * 服务端处理器
 */
public class HelloServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        // 收到消息直接打印输出
        System.out.println(channelHandlerContext.channel().remoteAddress() + " say: " + s);
        //返回客户端的消息“我已经收到了你的消息”
        channelHandlerContext.writeAndFlush("Received your message! \n");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端已经收到消息，并发给你一个问好？", CharsetUtil.UTF_8));
        super.channelReadComplete(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RemoteAddress : " + ctx.channel().remoteAddress() + " active !");
        ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
        super.channelActive(ctx);
    }
}

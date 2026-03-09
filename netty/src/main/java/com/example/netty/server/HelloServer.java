package com.example.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HelloServer {
    /**
     * 服务端端口
     */
    private static final int PORT = 8081;

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            // 创建服务端的启动对象，设置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 设置两个线程组 bossGroup,workGroup
            bootstrap.group(bossGroup, workGroup);
            // 设置服务端通道的实现类型
            bootstrap.channel(NioServerSocketChannel.class);
            // 设置线程队列得到的连接个数
            // 默认值128，SO_BACKLOG用于控制服务端在处理请求时的全连接队列（accept queue）的最大长度数的最大值
            bootstrap.option(ChannelOption.SO_BACKLOG, 128);
            // 设置保持活动连接状态
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            // 初始化通道对象
            bootstrap.childHandler(new HelloServerInitializer());

            // 绑定端口监听
            ChannelFuture f = bootstrap.bind(PORT).sync();

            // 监听服务器关闭监听
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }
}

package org.example.part2.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.example.part2.client.netty.NettyClientInitlizer;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/5 07:15
 * @Description: netty服务端
 */
public class NettyRpcServer implements RpcServer {

    @Override
    public void start(int port) {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class).childHandler(new NettyClientInitlizer());

        try {
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }

    @Override
    public void stop() {

    }
}

package org.example.part2.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/5 07:20
 * @Description: 初始化处理器
 */
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel sc) throws Exception {
        ChannelPipeline pipeline = sc.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4,
                0, 4));
        pipeline.addLast(new LengthFieldPrepender(4));

        pipeline.addLast(new ObjectEncoder());

        pipeline.addLast(new ObjectDecoder(new ClassResolver() {
            @Override
            public Class<?> resolve(String s) throws ClassNotFoundException {
                return Class.forName(s);
            }
        }));

        pipeline.addLast(new NettyServerHanlder());
    }
}

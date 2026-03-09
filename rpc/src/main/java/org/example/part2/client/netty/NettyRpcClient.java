package org.example.part2.client.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import lombok.NoArgsConstructor;
import org.example.part2.common.RpcClient;
import org.example.part2.common.RpcRequest;
import org.example.part2.common.RpcResponse;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/4 21:05
 * @Description: Netty客户端
 */
@NoArgsConstructor
public class NettyRpcClient implements RpcClient {

    private String address;
    private int port;

    public NettyRpcClient(String address, int port) {
        this.address = address;
        this.port = port;
    }


    private static final EventLoopGroup bossGroup;
    private static final Bootstrap bootstrap;

    // netty客户初始化
    static {
        bossGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        //NettyClientInitlizer 配置了netty对消息的处理机制
        bootstrap.group(bossGroup).channel(NioSocketChannel.class).handler(new NettyClientInitlizer());
    }

    public RpcResponse sendRequest(RpcRequest request) {
        try {
            // 创建一个channelFuture对象，代表这一个操作时间，sync方法表示堵塞直到connect完成
            ChannelFuture channelFuture = bootstrap.connect(address, port).sync();
            // channel 表示一个连接的单位
            Channel channel = channelFuture.channel();
            // 发送数据
            channel.writeAndFlush(request);
            // sync() 堵塞获取结果
            channel.closeFuture().sync();
//            channelFuture.addListener(new ChannelFutureListener() {
//                @Override
//                public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                    if (channelFuture.isSuccess()){
//
//                    } else {
//
//                    }
//                }
//            });
            // 阻塞的获取结果，通过给chancel设计别名，获取特定客户名字下的channel中的内容（这个在hanlder中设置）
            // AttrbuteKey时线程隔离的，不会有线程安全问题
            // 当前场景下选择堵塞获取结果
            // 其他场景也可以选择添加监听器的方式来异步获取结果 channel.addListiner
            AttributeKey<RpcResponse> key = AttributeKey.valueOf("RpcResponse");
            RpcResponse response = channel.attr(key).get();

            System.out.println(response.toString());
            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

package org.example.part2.common;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/7 06:42
 * @Description: rpcclient接口
 */
public interface RpcClient {

    public RpcResponse sendRequest(RpcRequest request);
}

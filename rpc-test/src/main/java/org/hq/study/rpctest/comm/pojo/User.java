package org.hq.study.rpctest.comm.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.io.Serializable;

/**
 * @author heqiang
 * @date 2026年03月05日15:39
 */
@Data
@Builder
@AllArgsConstructor
public class User implements Serializable {
    private String UserName;
    private int id;
    private boolean sex;
}

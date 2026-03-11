package org.example.part3.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/5 07:26
 * @Description: 用户实现类
 */
@Builder
@Data
@AllArgsConstructor
public class User implements Serializable {
    private String userName;
    private Integer id;
    private Boolean sex;
}

package org.example.part2.common;

import org.example.part2.common.pojo.User;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/5 07:31
 * @Description: 用户接口
 */
public interface UserService {
    // 获取用户数据
    User getUserByUserId(Integer id);
    // 新增用户数据
    Integer insertUser(User user);
}

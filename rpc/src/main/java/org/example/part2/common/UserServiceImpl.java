package org.example.part2.common;

import org.example.part2.common.pojo.User;

/**
 * @author: HQ
 * @version: 1.0
 * @date: 2026/3/5 07:34
 * @Description: 用户服务实现类
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(Integer id) {
        User user = new User("1", 12, Boolean.TRUE);
        System.out.println("查询记录成功");
        return user;
    }

    @Override
    public Integer insertUser(User user) {
        System.out.println("插入记录成功" + user.getUserName());
        return 1;
    }
}

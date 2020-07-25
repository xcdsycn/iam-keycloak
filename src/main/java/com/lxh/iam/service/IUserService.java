package com.lxh.iam.service;

import com.lxh.iam.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxh
 * @since 2020-07-25
 */
public interface IUserService extends IService<User> {

    // 登录
    String login(String username, String password);

    // 注册
    Integer register(User userToAdd);
}

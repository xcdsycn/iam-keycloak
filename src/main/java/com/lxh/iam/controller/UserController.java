package com.lxh.iam.controller;


import com.lxh.iam.entity.User;
import com.lxh.iam.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lxh
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    // 登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String createToken( String username,String password ) throws AuthenticationException {
        return userService.login( username, password ); // 登录成功会返回JWT Token给用户
    }

    // 注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Integer register( @RequestBody User addedUser ) throws AuthenticationException {
        return userService.register(addedUser);
    }
}

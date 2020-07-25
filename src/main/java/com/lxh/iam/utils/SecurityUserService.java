package com.lxh.iam.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.dreamyoung.mprelation.AutoMapper;
import com.lxh.iam.dto.UserDto;
import com.lxh.iam.entity.Role;
import com.lxh.iam.entity.User;
import com.lxh.iam.entity.UserRole;
import com.lxh.iam.mapper.RoleMapper;
import com.lxh.iam.mapper.UserMapper;
import com.lxh.iam.mapper.UserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {
    private final UserMapper userMapper;

    private final AutoMapper autoMapper;

    private final UserRoleMapper userRoleMapper;

    private final RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.lambda().eq(User::getUsername,s);
        User user = userMapper.selectOne(wrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        QueryWrapper<UserRole> userRoleQueryWrapper = new QueryWrapper<>();
        userRoleQueryWrapper.lambda().eq(UserRole::getUserId,user.getId());
        List<UserRole> userRoleList = userRoleMapper.selectList(userRoleQueryWrapper);
        List<Role> roles = userRoleList.stream().map(value -> {
            Role role = roleMapper.selectById(value.getRoleId());
            return role;
        }).collect(Collectors.toList());
        user.setRoles(roles);
//        autoMapper.mapper(user);
        UserDto dto = new UserDto();

        BeanUtils.copyProperties(user, dto);
        return  dto;
    }
}

package com.lxh.iam.service.impl;

import com.lxh.iam.entity.Role;
import com.lxh.iam.mapper.RoleMapper;
import com.lxh.iam.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ROLE 服务实现类
 * </p>
 *
 * @author lxh
 * @since 2020-07-25
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}

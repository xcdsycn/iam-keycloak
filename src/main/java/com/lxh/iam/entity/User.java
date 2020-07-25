package com.lxh.iam.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.dreamyoung.mprelation.*;
import com.lxh.iam.mapper.UserRoleMapper;
import com.lxh.iam.utils.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxh
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@AutoLazy(value = false)
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;


    @ManyToMany //多对多默认为延迟加载，即@Lazy(true)或此时不标注
    @JoinTable(targetMapper = UserRoleMapper.class) //第三方命名为StudentCourseMapper或CourseStudentMapper时@JoinTable注解一般可省略
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @InverseJoinColumn(name = "user_id", referencedColumnName = "id")
    @TableField(exist = false)
    private  List<Role> roles;
}

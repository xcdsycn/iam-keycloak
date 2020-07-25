package com.lxh.iam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxh.iam.utils.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@TableName("sys_user_role")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long roleId;



}

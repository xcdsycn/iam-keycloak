package com.lxh.iam.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lxh.iam.utils.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * ROLE
 * </p>
 *
 * @author lxh
 * @since 2020-07-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;



}

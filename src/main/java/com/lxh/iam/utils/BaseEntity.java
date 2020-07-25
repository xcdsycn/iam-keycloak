package com.lxh.iam.utils;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public abstract class BaseEntity {

    private Long id;

    @TableLogic
    private Integer deleted;
}

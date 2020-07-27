package com.lxh.iam.exception;

import lombok.Data;

@Data
public class BizException extends RuntimeException {
    private String errorCode;

    private String errorMessage;
}

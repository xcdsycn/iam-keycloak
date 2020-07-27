package com.lxh.iam.advice;

import com.lxh.iam.utils.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ActionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBody handler(Exception ex) {
        log.error("统一异常处理", ex);
        ResultBody error = ResultBody.error("400", ex.toString());
        return error;
    }
}

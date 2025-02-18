package com.yc.security.controller;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.yc.common.core.base.enums.ResultCode;
import com.yc.common.core.base.result.ResultBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:41
 */

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OverallExceptionHandler {

    /**
     * 用户接口基本鉴权
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NotLoginException.class)
    public ResultBody handUserExceptionHandler(NotLoginException e) {
        e.printStackTrace();
        // 判断场景值，定制化异常信息
        String message = "";
        if (e.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        } else if (e.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        } else if (e.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        } else if (e.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        } else if (e.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        } else {
            message = "当前会话未登录";
        }
        return ResultBody.fail(ResultCode.TOKEN_ERROR.getCode(), message);
    }

    /**
     * 权限
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NotPermissionException.class)
    public ResultBody handNotPermissionExceptionHandler(NotPermissionException e) {
        e.printStackTrace();
        return ResultBody.fail(ResultCode.PERM_ERROR.getCode(), e.getMessage());
    }

    /**
     * 角色
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NotRoleException.class)
    public ResultBody handNotNotRoleExceptionHandler(NotRoleException e) {
        e.printStackTrace();
        return ResultBody.fail(ResultCode.ROLE_ERROR.getCode(), e.getMessage());
    }

}

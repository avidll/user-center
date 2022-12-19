package com.woth.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author woth
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 5077654850695387889L;

    private String userAccount;

    private String userPassword;
}

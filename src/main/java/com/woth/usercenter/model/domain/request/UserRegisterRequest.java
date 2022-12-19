package com.woth.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author woth
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3904280998483698150L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

}

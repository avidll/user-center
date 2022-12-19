package com.woth.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 *  帖子创建请求体
 *
 */
@Data
public class CreatePostRequest implements Serializable {

    private static final long serialVersionUID = 7535099156891194357L;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 标题
     */
    private String title;

    /**
     * 帖子标签类型 例如 失物招领，校园美食...
     */
    private String postType;

    /**
     * 帖子封面
     */
    private String postImage;

    /**
     * 文章内容
     */
    private String postContext;

}

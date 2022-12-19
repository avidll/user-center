package com.woth.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 帖子
 * @TableName post
 */
@TableName(value ="post")
@Data
public class Post implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long postId;

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

    /**
     * 帖子状态 0-正常 1-被举报
     */
    private Integer postStatus;

    /**
     * 创建时间

     */
    private Date createTime;

    /**
     * 更新时间 
     */
    private Date updateTime;

    /**
     * 是否删除 0 1 (逻辑删除)
     */
    @TableLogic
    private Byte isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
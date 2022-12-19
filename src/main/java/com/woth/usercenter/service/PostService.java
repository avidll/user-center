package com.woth.usercenter.service;

import com.woth.usercenter.model.domain.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woth.usercenter.model.domain.request.CreatePostRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 帖子服务
 *
 */
public interface PostService extends IService<Post> {

    /**
     * 新建帖子
     *
     * @param createPostRequest 得到创建帖子所需的信息
     * @return 新建帖子的id
     */
    long createPost(@RequestBody CreatePostRequest createPostRequest);

    /**
     * 通过帖子标签查找帖子
     *
     * @param postType 帖子标签 例如 失物招领
     * @return 同一类型的帖子
     */
    List<Post> findPostsByType(String postType);

}

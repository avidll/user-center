package com.woth.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woth.usercenter.common.ErrorCode;
import com.woth.usercenter.exception.BusinessException;
import com.woth.usercenter.model.domain.Post;
import com.woth.usercenter.model.domain.request.CreatePostRequest;
import com.woth.usercenter.service.PostService;
import com.woth.usercenter.mapper.PostMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 帖子服务实现类
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
        implements PostService {

    @Resource
    private PostMapper postMapper;

    @Override
    public long createPost(CreatePostRequest createPostRequest) {
        // 1.校验
        if (createPostRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        String userAccount = createPostRequest.getUserAccount();
        String username = createPostRequest.getUsername();
        String avatarUrl = createPostRequest.getAvatarUrl();
        String title = createPostRequest.getTitle();
        String postImage = createPostRequest.getPostImage();
        String postContext = createPostRequest.getPostContext();
        String postType = createPostRequest.getPostType();
        if (StringUtils.isAnyBlank(userAccount, username, avatarUrl)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "参数为空");
        }
        if (StringUtils.isBlank(title)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请填写标题");
        }
        if (StringUtils.isBlank(postContext)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请填写内容");
        }
        // 2.插入数据
        Post post = new Post();
        post.setUserAccount(userAccount);
        post.setUsername(username);
        post.setAvatarUrl(avatarUrl);
        post.setTitle(title);
        post.setPostImage(postImage);
        post.setPostContext(postContext);
        post.setPostType(postType);
        boolean saveResult = this.save(post);
        if (!saveResult) {
            throw new BusinessException(ErrorCode.SAVE_ERROR, "保存错误");
        }
        return post.getPostId();
    }

    @Override
    public List<Post> findPostsByType(String postType) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("postType",postType);
        return this.listByMap(map);
    }
}





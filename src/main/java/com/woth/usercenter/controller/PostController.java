package com.woth.usercenter.controller;

import com.woth.usercenter.common.BaseResponse;
import com.woth.usercenter.common.ErrorCode;
import com.woth.usercenter.common.ResultUtils;
import com.woth.usercenter.exception.BusinessException;
import com.woth.usercenter.model.domain.Post;
import com.woth.usercenter.model.domain.User;
import com.woth.usercenter.model.domain.request.CreatePostRequest;
import com.woth.usercenter.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.woth.usercenter.constant.UserConstant.ADMIN_ROLE;
import static com.woth.usercenter.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 帖子接口
 */

@RestController
@RequestMapping("/posts")
public class PostController {

    @Resource
    private PostService postService;

    @PostMapping("/create")
    public BaseResponse<Long> createPost(@RequestBody(required = false) CreatePostRequest createPostRequest) {
        if (createPostRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long result = postService.createPost(createPostRequest);
        return ResultUtils.success(result);
    }

    @GetMapping("/findByType")
    public BaseResponse<List<Post>> findPostByType(String postType) {
        List<Post> result = postService.findPostsByType(postType);
        return ResultUtils.success(result);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deletePost(long postId, HttpServletRequest request) {
        //鉴权，管理员和帖子用户才能删除
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        User user = (User) userObj;
        if (user.getUserRole() != ADMIN_ROLE) {
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        if (!postService.getById(postId).getUserAccount().equals(user.getUserAccount())) {
            throw new BusinessException(ErrorCode.NO_AUTH);
        }
        //帖子是否存在
        if (postId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean result = postService.removeById(postId);
        return ResultUtils.success(result);
    }
}

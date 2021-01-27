package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.ForumComment;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.ForumCommentServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ForumCommentReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum/comment")
// Pour chaque controleur, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForumCommentController {

    ForumCommentServiceImpl forumCommentService;

    @PostMapping("/find-comments-by-subject/{id}")
    public BaseResVO findAllCommentsBySubject(@PathVariable int id){
        List<ForumComment> commentList = this.forumCommentService.findCommentBySubjectId(id);
        if(commentList != null){
            return ResultVOUtils.success(commentList);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/find-comments-by-id/{id}")
    public BaseResVO findCommentsById(@PathVariable int id){
        ForumComment forumComment = this.forumCommentService.findForumCommentById(id);
        if(forumComment != null){
            return ResultVOUtils.success(forumComment);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/add-forum-comments")
    public BaseResVO addComments(@RequestBody ForumCommentReqVO forumCommentReqVO){
        ForumComment forumComment = this.forumCommentService.insertForumComment(forumCommentReqVO.getForumComment());
        if(forumComment != null){
            return ResultVOUtils.success(forumComment);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/update-comments")
    public BaseResVO updateComments(@RequestBody ForumCommentReqVO forumCommentReqVO){
        ForumComment forumComment = this.forumCommentService.updateForumComment(forumCommentReqVO.getForumComment());
        if(forumComment != null){
            return ResultVOUtils.success(forumComment);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/delete-comments/{id}")
    public BaseResVO deleteCommentsById(@PathVariable int id){
        this.forumCommentService.deleteForumCommentById(id);
        return ResultVOUtils.success(null);
    }

}

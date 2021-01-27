package com.projectagile.webprojectagile.controller;


import com.projectagile.webprojectagile.entity.ForumSubject;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.ForumSubjectServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ForumSubjectReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ForumSubjectController {

    ForumSubjectServiceImpl forumSubjectService;

    @PostMapping("/find-all-forum-subjects")
    public BaseResVO findAllForumSubject(){
        List<ForumSubject> forumSubjectList = forumSubjectService.findAllForumSubject();
        if(forumSubjectList != null){
            return ResultVOUtils.success(forumSubjectList);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/add-forum-subject")
    public BaseResVO addForumSubject(@RequestBody ForumSubjectReqVO forumSubjectReqVO){
        ForumSubject forumSubject = this.forumSubjectService.insertForumSubject(forumSubjectReqVO.getForumSubject());
        if(forumSubject != null){
            return ResultVOUtils.success(forumSubject);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/update-forum-subject")
    public BaseResVO updateForumSubject(@RequestBody ForumSubjectReqVO forumSubjectReqVO){
        ForumSubject forumSubject = this.forumSubjectService.updateForumSubject(forumSubjectReqVO.getForumSubject());
        if(forumSubject != null){
            return ResultVOUtils.success(forumSubject);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/find-forum-subject-by-id/{id}")
    public BaseResVO findForumSubjectById(@PathVariable int id){
        ForumSubject forumSubject = this.forumSubjectService.findForumSubjectById(id);
        if(forumSubject != null){
            return ResultVOUtils.success(forumSubject);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/delete-forum-subject-by-id/{id}")
    public BaseResVO deleteForumSubjectById(@PathVariable int id){
        this.forumSubjectService.deleteForumSubjectById(id);
        return ResultVOUtils.success(null);
    }
}

package com.projectagile.webprojectagile.controller;


import com.projectagile.webprojectagile.entity.ForumSubject;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.ForumSubjectServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/forum")
@AllArgsConstructor(onConstructor = @__(@Autowired))
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
}

package com.projectagile.webprojectagile.controller;


import com.projectagile.webprojectagile.entity.ForumSubject;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.ForumSubjectServiceImpl;
import com.projectagile.webprojectagile.service.impl.ForumTagServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ForumSubjectReqVO;
import com.projectagile.webprojectagile.vo.req.TagReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controleur recoit les requetes du front et renvoie des réponses
 * Ici : reception des requetes relatives aux sujets du forum
 */

@RestController
@RequestMapping("/forum")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ForumSubjectController {

    ForumTagServiceImpl forumTagService;

    ForumSubjectServiceImpl forumSubjectService;

    @PostMapping("/find-all-forum-subjects")
    public BaseResVO findAllForumSubject() {
        List<ForumSubject> forumSubjectList = forumSubjectService.findAllForumSubject();
        if (forumSubjectList != null) {
            return ResultVOUtils.success(forumSubjectList);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/add-forum-subject")
    public BaseResVO addForumSubject(@RequestBody ForumSubjectReqVO forumSubjectReqVO) {
        System.out.println(forumSubjectReqVO.getForumSubject());
        ForumSubject forumSubject = this.forumSubjectService.insertForumSubject(forumSubjectReqVO.getForumSubject());
        if (forumSubject != null) {
            return ResultVOUtils.success(forumSubject);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/update-forum-subject")
    public BaseResVO updateForumSubject(@RequestBody ForumSubjectReqVO forumSubjectReqVO) {
        ForumSubject forumSubject = this.forumSubjectService.updateForumSubject(forumSubjectReqVO.getForumSubject());
        if (forumSubject != null) {
            return ResultVOUtils.success(forumSubject);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/find-forum-subject-by-id/{id}")
    public BaseResVO findForumSubjectById(@PathVariable int id) {
        ForumSubject forumSubject = this.forumSubjectService.findForumSubjectById(id);
        if (forumSubject != null) {
            return ResultVOUtils.success(forumSubject);
        } else {
            return ResultVOUtils.error();
        }
    }
    @PostMapping("/find-forum-subject-by-title/{title}")
    public BaseResVO findForumSubjectByTitle(@PathVariable String title) {
        List<ForumSubject> listSubject = this.forumSubjectService.searchSubjectByTitle(title);
        if (listSubject != null) {
            return ResultVOUtils.success(listSubject);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/delete-forum-subject-by-id/{id}")
    public BaseResVO deleteForumSubjectById(@PathVariable int id) {
        this.forumSubjectService.deleteForumSubjectById(id);
        return ResultVOUtils.success(null);
    }

    @PostMapping("/add-forum-tag/{tag}")
    public BaseResVO addForumTag(@PathVariable String tag){
        tag = tag.toLowerCase();
        return ResultVOUtils.success(forumTagService.addTag(tag));
    }

    @PostMapping("/find-all-tags")
    public BaseResVO findAllTag(){
        return ResultVOUtils.success(forumTagService.findAllTags());
    }

    @PostMapping("/find-by-tags")
    public BaseResVO findByTag(@RequestBody TagReqVO tagReqVO){
        return ResultVOUtils.success(forumSubjectService.findByTagList(tagReqVO.getTagList()));
    }

}

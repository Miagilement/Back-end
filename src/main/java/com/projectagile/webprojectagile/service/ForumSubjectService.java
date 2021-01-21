package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.ForumSubject;

import java.util.List;
import java.util.Optional;

public interface ForumSubjectService {
    List<ForumSubject> findAllForumSubject();
    ForumSubject insertForumSubject(ForumSubject forumSubject);
    ForumSubject updateForumSubject(ForumSubject forumSubject);
    ForumSubject findForumSubjectById(int id);
    void deleteForumSubjectById(int id);

}

package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.ForumComment;
import com.projectagile.webprojectagile.entity.ForumSubject;

import java.util.List;

public interface ForumCommentService {
    List<ForumComment> findCommentBySubjectId(int id);
    ForumComment findForumCommentById(int id);
    ForumComment insertForumComment(ForumComment forumComment);
    ForumComment updateForumComment(ForumComment forumComment);
    void deleteForumCommentById(int id);
}

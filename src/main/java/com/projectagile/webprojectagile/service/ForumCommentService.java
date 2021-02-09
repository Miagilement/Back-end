package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.ForumComment;
import com.projectagile.webprojectagile.entity.ForumSubject;

import java.util.List;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface ForumCommentService {
    List<ForumComment> findCommentBySubjectId(int id);
    ForumComment findForumCommentById(int id);
    ForumComment insertForumComment(ForumComment forumComment);
    ForumComment updateForumComment(ForumComment forumComment);
    void deleteForumCommentById(int id);
}

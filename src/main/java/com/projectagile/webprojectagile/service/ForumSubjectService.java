package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.ForumSubject;

import java.util.List;
import java.util.Optional;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface ForumSubjectService {
    List<ForumSubject> findAllForumSubject();
    ForumSubject insertForumSubject(ForumSubject forumSubject);
    ForumSubject updateForumSubject(ForumSubject forumSubject);
    ForumSubject findForumSubjectById(int id);
    ForumSubject findForumSubjectByTitle(String title);
    void deleteForumSubjectById(int id);

}

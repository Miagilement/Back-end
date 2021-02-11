package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.ForumSubject;
import com.projectagile.webprojectagile.entity.ForumTag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

public interface ForumSubjectDao extends CrudRepository <ForumSubject, Integer> {
    List<ForumSubject> findByForumTagList(ForumTag tag);

    List<ForumSubject> findByTitleContains(String title);

    ForumSubject findByTitle(String title);

    List<ForumSubject> findByForumTagListIsIn(List<ForumTag> tagList);
}

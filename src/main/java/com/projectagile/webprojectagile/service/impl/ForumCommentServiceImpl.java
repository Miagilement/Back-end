package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.dao.ForumCommentDao;
import com.projectagile.webprojectagile.dao.IndividualDao;
import com.projectagile.webprojectagile.dao.ProfileDao;
import com.projectagile.webprojectagile.entity.ForumComment;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.entity.Role;
import com.projectagile.webprojectagile.enums.RoleList;
import com.projectagile.webprojectagile.service.ForumCommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Implémentation de l'interface service
 * Définition des fontions (fonctionnalités de la plateforme)
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForumCommentServiceImpl implements ForumCommentService {

    ForumCommentDao forumCommentDao;

    ProfileDao profileDao;

    EnterpriseDao enterpriseDao;

    IndividualDao individualDao;

    @Override
    public List<ForumComment> findCommentBySubjectId(int id) {
        return this.forumCommentDao.findBySubjectId(id);
    }

    @Override
    public ForumComment findForumCommentById(int id) {
        return this.forumCommentDao.findById(id).get();
    }

    @Override
    public ForumComment insertForumComment(ForumComment forumComment) {
        forumComment.setDateComment(new Date());
        String authorId = forumComment.getAuthorId();
        switch ((profileDao.findById(authorId).get().getRoles().get(0).getRoleName())){
            case "USER_ENTERPRISE":
                forumComment.setAuthorName(enterpriseDao.findById(authorId).get().getNameEnterprise());
            case "USER_INDIVIDUAL":
                forumComment.setAuthorName(individualDao.findById(authorId).get().getUserName());
        }
        return this.forumCommentDao.save(forumComment);
    }

    @Override
    public ForumComment updateForumComment(ForumComment forumComment) {
        ForumComment forumComment1 = this.forumCommentDao.findById(forumComment.getId()).get();
        forumComment1.setText(forumComment.getText());
        return this.forumCommentDao.save(forumComment1);
    }

    @Override
    public void deleteForumCommentById(int id) {
        this.forumCommentDao.deleteById(id);
    }
}

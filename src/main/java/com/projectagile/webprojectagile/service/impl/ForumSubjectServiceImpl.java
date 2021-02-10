package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.dao.ForumSubjectDao;
import com.projectagile.webprojectagile.dao.IndividualDao;
import com.projectagile.webprojectagile.dao.ProfileDao;
import com.projectagile.webprojectagile.entity.ForumSubject;
import com.projectagile.webprojectagile.service.ForumSubjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implémentation de l'interface service
 * Définition des fontions (fonctionnalités de la plateforme)
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForumSubjectServiceImpl implements ForumSubjectService {

    ForumSubjectDao forumSubjectDao;

    ProfileDao profileDao;

    IndividualDao individualDao;

    EnterpriseDao enterpriseDao;

    @Override
    public List<ForumSubject> findAllForumSubject(){
        return (List<ForumSubject>) forumSubjectDao.findAll();
    }

    @Override
    public ForumSubject insertForumSubject(ForumSubject forumSubject) {
        String authorId = forumSubject.getAuthorId();
        switch ((profileDao.findById(authorId).get().getRoles().get(0).getRoleName())){
            case "USER_ENTERPRISE":
                forumSubject.setAuthorName(enterpriseDao.findById(authorId).get().getNameEnterprise());
            case "USER_INDIVIDUAL":
                forumSubject.setAuthorName(individualDao.findById(authorId).get().getUserName());
        }
        forumSubject.setDatePost(new Date());
        return forumSubjectDao.save(forumSubject);
    }

    @Override
    public ForumSubject updateForumSubject(ForumSubject forumSubject) {
        ForumSubject forumSubject1 = this.forumSubjectDao.findById(forumSubject.getId()).get();
        forumSubject1.setDateLastModified(new Date());
        forumSubject1.setText(forumSubject.getText());
        forumSubject1.setTitle(forumSubject.getTitle());
        return forumSubjectDao.save(forumSubject1);
    }

    @Override
    public ForumSubject findForumSubjectById(int id) {
        return forumSubjectDao.findById(id).get();
    }
    @Override
    public ForumSubject findForumSubjectByTitle(String title) {
        return forumSubjectDao.findByTitle(title);
    }

    @Override
    public void deleteForumSubjectById(int id) {
        forumSubjectDao.deleteById(id);
    }
}

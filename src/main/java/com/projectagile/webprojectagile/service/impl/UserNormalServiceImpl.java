package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.UserNormalDao;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.entity.UserNormal;
import com.projectagile.webprojectagile.service.UserNormalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface service
 * Définition des fontions
 */

@Service
// Pour chaque service, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserNormalServiceImpl implements UserNormalService {

    UserNormalDao userNormalDao;

    @Override
    public UserNormal insertProfile(UserNormal userNormal) {
        userNormal.setUserPassword(BCrypt.hashpw(userNormal.getUserPassword(), BCrypt.gensalt()));
        return userNormalDao.save(userNormal);
    }

    @Override
    public List<UserNormal> findAllProfile() {
        return (List<UserNormal>) userNormalDao.findAll();
    }

    @Override
    public UserNormal findProfileById(String uid) {
        return userNormalDao.findById(uid).get();
    }

    @Override
    public boolean isExist(UserNormal userNormal) {
        Profile profileExist = userNormalDao.findByUserEmail(userNormal.getUserEmail());
        return profileExist != null;
    }

    @Override
    public UserNormal updateUserInfo(UserNormal userNormal) {
        return this.userNormalDao.save(userNormal);
    }
}

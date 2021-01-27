package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ProfileDao;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface service
 * Définition des fontions
 */

@Service
// Pour chaque service, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileServiceImpl implements ProfileService {
    
    ProfileDao profileDao;

    @Override
    public Profile insertProfile(Profile profile) {
        return profileDao.save(profile);
    }

    @Override
    public List<Profile> findAllProfile() {
        return (List<Profile>) profileDao.findAll();
    }

    @Override
    public Profile findProfileById(String uid) {
        return profileDao.findById(uid).get();
    }

    @Override
    public boolean isExistProfile(Profile profile) {
        Profile profileExist = profileDao.findByUserEmail(profile.getUserEmail());
        return profileExist != null;
    }

    @Override
    public Profile updateUserInfo(Profile profile) {
        return this.profileDao.save(profile);
    }
}

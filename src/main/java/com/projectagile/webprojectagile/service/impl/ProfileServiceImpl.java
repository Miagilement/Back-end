package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ProfileDao;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfileServiceImpl implements ProfileService {

    ProfileDao profileDao;

    @Override
    public Profile findProfileByEmail(String email) {
        return profileDao.findByUserEmail(email);
    }

    @Override
    public void updateProfile(Profile profile) {
        profileDao.save(profile);
    }

    @Override
    public boolean isExistProfile(Profile profile) {
        if(profileDao.findByUserEmail(profile.getUserEmail()) != null){
            return true;
        } else {
            return false;
        }
    }
}

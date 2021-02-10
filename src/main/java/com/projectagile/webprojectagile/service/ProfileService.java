package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.service.impl.ProfileServiceImpl;

public interface ProfileService {
    Profile findProfileByEmail(String email);
    void updateProfile(Profile profile);
    boolean isExistProfile(Profile profile);
}

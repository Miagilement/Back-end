package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Profile;

import java.util.List;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface ProfileService {
    
    Profile insertProfile(Profile profile);
    List<Profile> findAllProfile();
    Profile findProfileById(String uid);
    boolean isExistProfile(Profile profile);
    Profile updateUserInfo(Profile profile);
}

package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.UserNormal;

import java.util.List;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface UserNormalService {

    UserNormal insertProfile(UserNormal userNormal);

    List<UserNormal> findAllProfile();

    UserNormal findProfileById(String uid);

    boolean isExist(UserNormal userNormal);

    UserNormal updateUserInfo(UserNormal userNormal);
}

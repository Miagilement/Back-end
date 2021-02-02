package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Role;

import java.util.List;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface RoleService {
    Role insertRole(Role role);
    void deleteRole(long id);
    List<Role> findAllRole();
}

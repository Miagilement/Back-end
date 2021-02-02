package com.projectagile.webprojectagile.dao;


import com.projectagile.webprojectagile.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

@Repository
@Transactional
public interface RoleDao extends CrudRepository<Role, Long> {

    //Requete générée automatiquement par Hibernate
    Role findByRoleName(String roleName);
}



package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

public interface ProfileDao extends CrudRepository<Profile, String> {

    Profile findByUserEmail(String userEmail);

}

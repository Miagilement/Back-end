package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Particulier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

public interface ParticulierDao extends CrudRepository<Particulier, String> {
    
    @Query(value = "SELECT * FROM particulier as e WHERE e.user_email = ?1", nativeQuery = true)
    Particulier findByUserEmail(String userEmail);;
}

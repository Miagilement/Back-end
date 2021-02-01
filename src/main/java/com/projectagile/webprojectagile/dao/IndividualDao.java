package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Individual;
import org.springframework.data.repository.CrudRepository;

/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

public interface IndividualDao extends CrudRepository<Individual, String> {

//    @Query(value = "SELECT * FROM user_normal as un WHERE un.user_email = ?1", nativeQuery = true)
    Individual findByUserEmail(String userEmail);

    boolean existsByUserEmail(String userEmail);

}

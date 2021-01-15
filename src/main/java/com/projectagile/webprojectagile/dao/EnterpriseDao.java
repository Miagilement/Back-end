package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Enterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

public interface EnterpriseDao extends CrudRepository<Enterprise, String> {

    @Query(value = "SELECT * FROM enterprise as e WHERE e.siret = ?1", nativeQuery = true)
    Enterprise findBySiret(String siret);
}

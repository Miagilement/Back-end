package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Enterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

public interface EnterpriseDao extends CrudRepository<Enterprise, String> {

    Enterprise findBySiret(String siret);

    //Requete générée automatiquement par Hibernate
    //Equivalent à : @Query(value = "SELECT * FROM enterprise as un WHERE e.user_email = ?1", nativeQuery = true)
    Enterprise findByUserEmailOrSiret(String userEmail, String Siret);

    @Query(value = "SELECT * FROM enterprise AS e INNER JOIN profile AS p ON e.uid = p.uid WHERE (e.region = ?1 OR ?1 = '') AND (e.sector_activity = ?2 OR ?2 = '')", nativeQuery = true)
    List<Enterprise> findByAttribute(String region, String sectorActivity);

}

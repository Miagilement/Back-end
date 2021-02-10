package com.projectagile.webprojectagile.service;


import com.projectagile.webprojectagile.entity.Enterprise;

import java.util.List;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface EnterpriseService {
    Enterprise insertEnterprise(Enterprise enterprise);
    List<Enterprise> findAllEnterprise();
    Enterprise findByIdEnterprise(String uid);
    List<Enterprise> findEnterpriseByAttribute(String region, String sector);
}

package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Particulier;

import java.util.List;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface ParticulierService {
    
    Particulier insertParticulier(Particulier particulier);
    List<Particulier> findAllParticulier();
    Particulier findByIdParticulier(String uid);
    boolean isExistParticulier(Particulier particulier);
}

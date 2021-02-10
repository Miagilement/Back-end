package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Individual;

import java.util.List;

/**
 * Interface pour définir la logique front-end
 * Ici sont implementées toutes les fontionnalités du logiciel
 * Déclaration des fonctions nécessaires
 */

public interface IndividualService {

    Individual insertIndividual(Individual individual);

    List<Individual> findAllIndividual();

    Individual findIndividualById(String uid);


    Individual updateIndividualInfo(Individual individual);

}

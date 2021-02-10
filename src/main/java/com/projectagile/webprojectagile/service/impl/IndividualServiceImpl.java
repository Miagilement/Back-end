package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.dao.IndividualDao;
import com.projectagile.webprojectagile.dao.RoleDao;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.Individual;
import com.projectagile.webprojectagile.entity.Role;
import com.projectagile.webprojectagile.enums.RoleList;
import com.projectagile.webprojectagile.service.IndividualService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Implémentation de l'interface service
 * Définition des fontions (fonctionnalités de la plateforme)
 */

@Service
// Pour chaque service, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IndividualServiceImpl implements IndividualService {

    IndividualDao individualDao;

    EnterpriseDao enterpriseDao;

    RoleDao roleDao;

    @Override
    public Individual insertIndividual(Individual individual) {
        individual.setUserPassword(BCrypt.hashpw(individual.getUserPassword(), BCrypt.gensalt()));

        List<Role> roles = new ArrayList<>();
        roles.add(roleDao.findByRoleName(RoleList.USER_INDIVIDUAL.getRoleName()));
        individual.setRoles(roles);
        return individualDao.save(individual);
    }

    @Override
    public List<Individual> findAllIndividual() {
        return (List<Individual>) individualDao.findAll();
    }

    @Override
    public Individual findIndividualById(String uid) {
        return individualDao.findById(uid).get();
    }

    @Override
    public Individual updateIndividualInfo(Individual individual) {
        Individual individual1 = individualDao.findById(individual.getUid()).get();
        if (individual1 != null) {
            individual1.setUserName(individual.getUserName());
            individual1.setUserType(individual.getUserType());
            individual1.setUserPassword(individual.getUserPassword());
            return this.individualDao.save(individual1);
        } else {
            return null;
        }

    }
}

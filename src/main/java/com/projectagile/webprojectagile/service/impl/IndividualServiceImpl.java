package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.dao.RoleDao;
import com.projectagile.webprojectagile.dao.IndividualDao;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.Individual;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.entity.Role;
import com.projectagile.webprojectagile.enums.RoleList;
import com.projectagile.webprojectagile.service.IndividualService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Individual insertProfile(Individual individual) {
        individual.setUserPassword(BCrypt.hashpw(individual.getUserPassword(), BCrypt.gensalt()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.findByRoleName(RoleList.USER_INDIVIDUAL.getRoleName()));
        individual.setRoles(roles);
        return individualDao.save(individual);
    }

    @Override
    public List<Individual> findAllProfile() {
        return (List<Individual>) individualDao.findAll();
    }

    @Override
    public Individual findProfileById(String uid) {
        return individualDao.findById(uid).get();
    }

    @Override
    public boolean isExist(Individual individual) {
        Enterprise enterpriseExist = enterpriseDao.findByUserEmailOrSiret(individual.getUserEmail(), null);
        Individual individualExist = individualDao.findByUserEmail(individual.getUserEmail());
        return enterpriseExist != null || individualExist != null;
    }

    @Override
    public Individual updateUserInfo(Individual individual) {
        return this.individualDao.save(individual);
    }
}

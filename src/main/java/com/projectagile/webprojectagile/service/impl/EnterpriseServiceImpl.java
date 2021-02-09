package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.dao.IndividualDao;
import com.projectagile.webprojectagile.dao.RoleDao;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.Individual;
import com.projectagile.webprojectagile.entity.Role;
import com.projectagile.webprojectagile.enums.RoleList;
import com.projectagile.webprojectagile.service.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class EnterpriseServiceImpl implements EnterpriseService {

    EnterpriseDao enterpriseDao;

    IndividualDao individualDao;

    RoleDao roleDao;

    @Override
    public Enterprise insertEnterprise(Enterprise enterprise) {
        enterprise.setUserPassword(BCrypt.hashpw(enterprise.getUserPassword(), BCrypt.gensalt()));
        enterprise.setUserEmail(enterprise.getUserEmail().toLowerCase());
        List<Role> roles = new ArrayList<>();
        roles.add(roleDao.findByRoleName(RoleList.USER_ENTERPRISE.getRoleName()));
        enterprise.setRoles(roles);
        System.out.println(enterprise.getUserPassword());
        return enterpriseDao.save(enterprise);
    }

    @Override
    public List<Enterprise> findAllEnterprise() {
        return (List<Enterprise>) enterpriseDao.findAll();
    }

    @Override
    public Enterprise findByIdEnterprise(String uid) {
        return enterpriseDao.findById(uid).get();
    }

    @Override
    public List<Enterprise> findEnterpriseByAttribute(String region, String sector) {
        if(region.equals("any")&&sector.equals("any")){
            return (List<Enterprise>) enterpriseDao.findAll();
        }
        if(region.equals("any")){
            return enterpriseDao.findByAttribute("", sector);
        }
        if(sector.equals("any")){
            return enterpriseDao.findByAttribute(region, "");
        }
        return enterpriseDao.findByAttribute(region, sector);
    }
}

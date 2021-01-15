package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.service.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface service
 * Définition des fontions
 */

@Service
// Pour chaque service, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnterpriseServiceImpl implements EnterpriseService {

    EnterpriseDao enterpriseDao;

    @Override
    public Enterprise insertEnterprise(Enterprise enterprise) {
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
    public boolean isExistEnterprise(Enterprise enterprise) {
        Enterprise enterpriseExist = enterpriseDao.findBySiret(enterprise.getSiret());
        return enterpriseExist != null;
    }
}
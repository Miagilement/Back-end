package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ParticulierDao;
import com.projectagile.webprojectagile.entity.Particulier;
import com.projectagile.webprojectagile.service.ParticulierService;
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
public class ParticulierServiceImpl implements ParticulierService{
    
    ParticulierDao particulierDao;

    @Override
    public Particulier insertParticulier(Particulier particulier) {
        return particulierDao.save(particulier);
    }

    @Override
    public List<Particulier> findAllParticulier() {
        return (List<Particulier>) particulierDao.findAll();
    }

    @Override
    public Particulier findByIdParticulier(String uid) {
        return particulierDao.findById(uid).get();
    }

    @Override
    public boolean isExistParticulier(Particulier particulier) {
        Particulier particulierExist = particulierDao.findByUserEmail(particulier.getUserEmail());
        return particulierExist != null;
    }
}

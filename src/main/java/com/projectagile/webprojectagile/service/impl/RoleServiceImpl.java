package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.RoleDao;
import com.projectagile.webprojectagile.entity.Role;
import com.projectagile.webprojectagile.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation de l'interface service
 * Définition des fontions (fonctionnalités de la plateforme)
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Override
    public Role insertRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleDao.deleteById(id);
    }

    @Override
    public List<Role> findAllRole() {
        return (List<Role>) roleDao.findAll();
    }
}

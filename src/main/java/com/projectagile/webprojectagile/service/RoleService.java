package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Role;

import java.util.List;

public interface RoleService {
    Role insertRole(Role role);
    void deleteRole(long id);
    List<Role> findAllRole();
}

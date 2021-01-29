package com.projectagile.webprojectagile.dao;


import com.projectagile.webprojectagile.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findByRoleName(String roleName);
}



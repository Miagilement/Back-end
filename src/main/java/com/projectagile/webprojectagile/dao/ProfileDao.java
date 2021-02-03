package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileDao extends CrudRepository<Profile, String> {

    Profile findByUserEmail(String userEmail);
}

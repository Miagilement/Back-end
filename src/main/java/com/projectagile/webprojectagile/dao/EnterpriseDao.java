package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Enterprise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface EnterpriseDao extends CrudRepository<Enterprise, String> {

    @Query(value = "SELECT * FROM enterprise as e WHERE e.siret = ?1", nativeQuery = true)
    Enterprise findBySiret(String siret);
}

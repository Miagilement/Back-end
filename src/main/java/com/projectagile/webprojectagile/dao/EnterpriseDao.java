package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Enterprise;
import org.springframework.data.repository.CrudRepository;

public interface EnterpriseDao extends CrudRepository<Enterprise, String> {
}

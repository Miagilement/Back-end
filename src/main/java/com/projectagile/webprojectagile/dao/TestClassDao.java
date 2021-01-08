package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.TestClass;
import org.springframework.data.repository.CrudRepository;

public interface TestClassDao extends CrudRepository<TestClass, Long> {
    TestClass findTestClassById(int id);
}

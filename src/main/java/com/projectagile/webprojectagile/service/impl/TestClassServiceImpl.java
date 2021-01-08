package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.TestClassDao;
import com.projectagile.webprojectagile.entity.TestClass;
import com.projectagile.webprojectagile.service.TestClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestClassServiceImpl implements TestClassService {

    @Autowired
    TestClassDao testClassDao;


    @Override
    public TestClass addTestClass(TestClass testClass) {
        return testClassDao.save(testClass);
    }

    @Override
    public TestClass findTestClassById(int id) {
        return testClassDao.findTestClassById(id);
    }

    @Override
    public List<TestClass> findAllTestClass() {
        return (List<TestClass>) testClassDao.findAll();
    }
}

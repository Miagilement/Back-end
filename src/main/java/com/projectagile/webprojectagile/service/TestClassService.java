package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.TestClass;

import java.util.List;

public interface TestClassService {
    TestClass addTestClass(TestClass testClass);
    TestClass findTestClassById(int id);
    List<TestClass> findAllTestClass();
}

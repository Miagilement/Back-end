package com.projectagile.webprojectagile.service;


import com.projectagile.webprojectagile.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {
    Enterprise insertEnterprise(Enterprise enterprise);
    List<Enterprise> findAllEnterprise();
    Enterprise findById(String uid);
}

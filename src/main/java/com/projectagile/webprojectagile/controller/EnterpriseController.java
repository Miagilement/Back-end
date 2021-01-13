package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.EnterpriseServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/info/enterprise")
public class EnterpriseController {

    @Autowired
    EnterpriseServiceImpl enterpriseService;

    @PostMapping("/find-all-enterprise")
    public BaseResVO findAllEnterprise(){
        List<Enterprise> enterpriseList = enterpriseService.findAllEnterprise();
        if(enterpriseList != null){
            return ResultVOUtils.success(enterpriseList);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/find-by-id/{uid}")
    public BaseResVO findEnterpriseById(@PathVariable String uid){
        Enterprise enterprise = enterpriseService.findById(uid);

        if(enterprise != null){
            return ResultVOUtils.success(enterprise);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }
}

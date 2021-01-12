package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.EnterpriseService;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.EnterpriseRegisterReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/enterprise")
public class EnterpriseRegisterController {

    @Autowired
    EnterpriseService enterpriseService;

    @PostMapping("/register")
    public BaseResVO enterpriseRegister(@RequestBody EnterpriseRegisterReqVO enterpriseRegisterReqVO){

        System.out.println(enterpriseRegisterReqVO.getTimeStamp());
        Enterprise enterprise = enterpriseService.insertEnterprise(enterpriseRegisterReqVO.getEnterprise());
        //TODO Verify data format
        if(enterprise != null){
            return ResultVOUtils.success(enterprise);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }
}

package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.EnterpriseService;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.EnterpriseRegisterReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user")
public class UserRegisterController {

    @Autowired
    EnterpriseService enterpriseService;

    //Pour les utilisateurs de l'entreprise
    @PostMapping("/enterprise/register")
    public BaseResVO enterpriseRegister(@Valid @RequestBody EnterpriseRegisterReqVO enterpriseRegisterReqVO) {
        System.out.println(enterpriseRegisterReqVO);
        if(enterpriseService.isExist(enterpriseRegisterReqVO.getEnterprise())){
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT);
        } else {
            return ResultVOUtils.success(enterpriseService.insertEnterprise(enterpriseRegisterReqVO.getEnterprise()));
        }
    }
}

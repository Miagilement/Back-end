package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.EnterpriseServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controleur recoit les requêtes du front-end
 */

@RestController
@RequestMapping("/info/enterprise")
// Pour chaque controleur, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnterpriseController {

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

    //le uid est récupéré dans l'url pour le renvoyer au front-end
    @PostMapping("/find-by-id/{uid}")
    public BaseResVO findEnterpriseById(@PathVariable String uid){
        Enterprise enterprise = enterpriseService.findByIdEnterprise(uid);
        if(enterprise != null){
            return ResultVOUtils.success(enterprise);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/find-by-attribute/{region}/{sector}")
    public BaseResVO findEnterpriseByAttribute(@PathVariable(value = "region") String region, @PathVariable(value = "sector") String sector){
        return ResultVOUtils.success(enterpriseService.findEnterpriseByAttribute(region, sector));
    }
}

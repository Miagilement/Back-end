package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.EnterpriseService;
import com.projectagile.webprojectagile.service.ParticulierService;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.EnterpriseRegisterReqVO;
import com.projectagile.webprojectagile.vo.req.ParticulierRegisterReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controler pour l'inscription des entreprises et particuliers
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user")
// Pour chaque service, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserRegisterController {

    EnterpriseService enterpriseService;
    ParticulierService particulierService;
    //Pour l'entreprise (lié au formulaire inscription entreprise)
    @PostMapping("/enterprise/register")
    public BaseResVO enterpriseRegister(@Valid @RequestBody EnterpriseRegisterReqVO enterpriseRegisterReqVO) {
        System.out.println(enterpriseRegisterReqVO);
        if(enterpriseService.isExistEnterprise(enterpriseRegisterReqVO.getEnterprise())){
            String[] listString = {"Le SIRET existe déja, veuillez vous connecter directement!"};
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT,listString);
        } else {
            return ResultVOUtils.success(enterpriseService.insertEnterprise(enterpriseRegisterReqVO.getEnterprise()));
        }
    }

    @PostMapping("/particulier/register")
    public BaseResVO particulierRegister(@Valid @RequestBody ParticulierRegisterReqVO particulierRegisterReqVO) {
        System.out.println(particulierRegisterReqVO);
        if(particulierService.isExistParticulier(particulierRegisterReqVO.getParticulier())){
            String[] listString = {"L'utilisateur existe déja, veuillez vous connecter directement!"};
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT,listString);
        } else {
            return ResultVOUtils.success(particulierService.insertParticulier(particulierRegisterReqVO.getParticulier()));
        }
    }
}

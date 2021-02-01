package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.EnterpriseServiceImpl;
import com.projectagile.webprojectagile.service.impl.IndividualServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.EnterpriseReqVO;
import com.projectagile.webprojectagile.vo.req.IndividualReqVO;
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

    EnterpriseServiceImpl enterpriseService;
    IndividualServiceImpl individualService;

    //Pour l'entreprise (lié au formulaire inscription entreprise)
    @PostMapping("/enterprise/register")
    public BaseResVO enterpriseRegister(@Valid @RequestBody EnterpriseReqVO enterpriseReqVO) {
        System.out.println(enterpriseReqVO);
        if (enterpriseService.isExistEnterprise(enterpriseReqVO.getEnterprise())) {
            String[] listString = {"Le SIRET existe déja, veuillez vous connecter directement!"};
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT, listString);
        } else {
            return ResultVOUtils.success(enterpriseService.insertEnterprise(enterpriseReqVO.getEnterprise()));
        }
    }

    @PostMapping("/normal/register")
    public BaseResVO particulierRegister(@RequestBody IndividualReqVO individualReqVO) {
        System.out.println(individualReqVO);
        if (individualService.isExist(individualReqVO.getIndividual())) {
            String[] listString = {"L'utilisateur existe déja, veuillez vous connecter directement!"};
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT, listString);
        } else {
            return ResultVOUtils.success(individualService.insertProfile(individualReqVO.getIndividual()));
        }
    }
}

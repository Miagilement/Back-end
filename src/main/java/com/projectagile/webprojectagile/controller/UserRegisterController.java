package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.ConfirmationToken;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.Individual;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.EmailServiceImpl;
import com.projectagile.webprojectagile.service.impl.EnterpriseServiceImpl;
import com.projectagile.webprojectagile.service.impl.IndividualServiceImpl;
import com.projectagile.webprojectagile.service.impl.ProfileServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.EnterpriseReqVO;
import com.projectagile.webprojectagile.vo.req.IndividualReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controleur pour l'inscription des entreprises et particuliers
 * Le controleur recoit les requetes du front et renvoie des réponses
 * Ici : reception des requetes relatives aux formulaires d'inscription entreprises & individus
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user")
// Pour chaque service, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserRegisterController {

    //injection de dépendances ? @Autowired
    EnterpriseServiceImpl enterpriseService;
    IndividualServiceImpl individualService;
    EmailServiceImpl emailService;
    ProfileServiceImpl profileService;
    //retirer les dao
    //créer des services qui appelent les dao

    //Pour l'entreprise (lié au formulaire inscription entreprise)
    @PostMapping("/enterprise/register")
    public BaseResVO enterpriseRegister(@Valid @RequestBody EnterpriseReqVO enterpriseReqVO) {
        System.out.println(enterpriseReqVO);
        enterpriseReqVO.getEnterprise().setUserEmail(enterpriseReqVO.getEnterprise().getUserEmail().toLowerCase());
        if (profileService.isExistProfile(enterpriseReqVO.getEnterprise())) {
            String[] listString = {"Le SIRET ou email est déja inscrit, veuillez vous connecter directement!"};
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT, listString);
        } else {
            Enterprise enterprise = enterpriseService.insertEnterprise(enterpriseReqVO.getEnterprise());
            ConfirmationToken confirmationToken = new ConfirmationToken(enterpriseReqVO.getEnterprise());
            emailService.saveToken(confirmationToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(enterpriseReqVO.getEnterprise().getUserEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setText("Cliquez sur ce lien pour completer votre inscription : "
                    + "http://localhost:8000/user/confirm-account?token=" + confirmationToken.getConfirmationToken());
            emailService.sendEmail(mailMessage);
            return ResultVOUtils.success(enterprise);
        }
    }

    @PostMapping("/individual/register")
    public BaseResVO individualRegister(@Valid @RequestBody IndividualReqVO individualReqVO) {
        System.out.println(individualReqVO);
        individualReqVO.getIndividual().setUserEmail(individualReqVO.getIndividual().getUserEmail().toLowerCase());
            if (profileService.isExistProfile(individualReqVO.getIndividual())) {
                String[] listString = {"L'utilisateur existe déja, veuillez vous connecter directement!"};
                return ResultVOUtils.error(ResultEnum.DATA_REPEAT, listString);
            } else {
                Individual individual = individualService.insertIndividual(individualReqVO.getIndividual());
                ConfirmationToken confirmationToken = new ConfirmationToken(individualReqVO.getIndividual());
                emailService.saveToken(confirmationToken);
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(individualReqVO.getIndividual().getUserEmail());
                mailMessage.setSubject("Complete Registration!");
                mailMessage.setText("Cliquez sur ce lien pour completer votre inscription : "
                        + "http://localhost:8000/user/confirm-account?token=" + confirmationToken.getConfirmationToken());
                emailService.sendEmail(mailMessage);
                return ResultVOUtils.success(individual);
            }
        }

        @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
        public BaseResVO confirmUserAccount (@RequestParam("token") String confirmationToken){
            ConfirmationToken token = emailService.findToken(confirmationToken);
            if (token != null) {
                Profile user = profileService.findProfileByEmail(token.getProfile().getUserEmail());
                user.setEnabled(true);
                profileService.updateProfile(user);
                return ResultVOUtils.success(user);
            } else {
                return ResultVOUtils.error(ResultEnum.USER_EMAIL_NOT);
            }
        }
}

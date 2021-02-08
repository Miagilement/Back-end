package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.dao.ConfirmationTokenDao;
import com.projectagile.webprojectagile.dao.IndividualDao;
import com.projectagile.webprojectagile.dao.ProfileDao;
import com.projectagile.webprojectagile.entity.ConfirmationToken;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.EnterpriseServiceImpl;
import com.projectagile.webprojectagile.service.impl.IndividualServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.EnterpriseReqVO;
import com.projectagile.webprojectagile.vo.req.IndividualReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    //retirer les dao
    //créer des services qui appelent les dao
    IndividualDao individualDao;
    ProfileDao profileDao;
    @Autowired
    private ConfirmationTokenDao confirmationTokenDao;

    //Pour l'entreprise (lié au formulaire inscription entreprise)
    @PostMapping("/enterprise/register")
    public BaseResVO enterpriseRegister(@Valid @RequestBody EnterpriseReqVO enterpriseReqVO) {
        System.out.println(enterpriseReqVO);
        if (enterpriseService.isExistEnterprise(enterpriseReqVO.getEnterprise())) {
            String[] listString = {"Le SIRET ou email est déja inscrit, veuillez vous connecter directement!"};
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT, listString);
        } else {
            ConfirmationToken confirmationToken = new ConfirmationToken(enterpriseReqVO.getEnterprise());
            confirmationTokenDao.save(confirmationToken);
            return ResultVOUtils.success(enterpriseService.insertEnterprise(enterpriseReqVO.getEnterprise()));
        }
    }

    @PostMapping("/individual/register")
    public BaseResVO individualRegister(@Valid @RequestBody IndividualReqVO individualReqVO) {
        System.out.println(individualReqVO);
        if (individualService.isExistIndividual(individualReqVO.getIndividual())) {
            String[] listString = {"L'utilisateur existe déja, veuillez vous connecter directement!"};
            return ResultVOUtils.error(ResultEnum.DATA_REPEAT, listString);
        } else {
            individualService.insertIndividual(individualReqVO.getIndividual());
            ConfirmationToken confirmationToken = new ConfirmationToken(individualReqVO.getIndividual());
            confirmationTokenDao.save(confirmationToken);
            return ResultVOUtils.success(individualReqVO.getIndividual());
        }
    }


/*
    SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userEntity.getEmailId());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setText("Cliquez sur ce lien pour completer votre inscription : "
                    +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("emailId", userEntity.getEmailId());

            modelAndView.setViewName("successfulRegisteration");

 */

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {

        ConfirmationToken token = confirmationTokenDao.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            Profile user = profileDao.findByUserEmail(token.getProfile().getUserEmail());
            user.setEnabled(true);
            profileDao.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","Le lien ne marche pas!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
}

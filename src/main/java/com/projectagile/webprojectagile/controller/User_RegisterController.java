package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.repository.*;
import com.projectagile.webprojectagile.service.EmailService;
import com.projectagile.webprojectagile.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class User_RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailService;

    /**
     * 
     * @param modelAndView
     * @param userEntity
     * @return
     */
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, UserEntity userEntity)
    {
        modelAndView.addObject("userEntity", userEntity);
        modelAndView.setViewName("register");
        return modelAndView;
    }
    //
    
    /**
     * Cette méthode est déclenchée à la fin du saisie de l'inscription
     * @param modelAndView
     * @param userEntity
     * @return
     */
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, UserEntity userEntity)
    {

    	UserEntity existingUser = userRepository.findByEmailIdIgnoreCase(userEntity.getEmailId());
       /**
        * Il vérifie et compare l'adresse e-mail de l'utilisateur avec celles existantes dans la base de données, s'il le trouve,
        Il enverra le message "Cette adresse email existe déjà!"
        */
        if(existingUser != null)
        {
            modelAndView.addObject("message","Cette adresse email existe deja!");
            // Envoie d'une page d'erreur
            modelAndView.setViewName("error");
        }
        /**
         * Sinon si l'adresse email fourni est nouvelle, les détails de l'utilisateur seront enrégistrés
         * et un jeton de confirmation à valider lui sera envoyé par mail!
         */
        else
        {
            userRepository.save(userEntity);

            ConfirmationToken confirmationToken = new ConfirmationToken(userEntity);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(userEntity.getEmailId());
            mailMessage.setSubject("Enregistrement reussi");
            mailMessage.setText("Veuillez cliquer sur ce lien pour valider votre inscription: "
            +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("emailId", userEntity.getEmailId());

            // A intégrer en Front
            modelAndView.setViewName("successfulRegisteration");
        }

        return modelAndView;
    }
    
    /**
     * le lien est soit validé
     * @param modelAndView
     * @param confirmationToken
     * @return
     */

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
        	UserEntity user = userRepository.findByEmailIdIgnoreCase(token.getUserEntity().getEmailId());
            user.setEnabled(true);
            userRepository.save(user);
            //redirection vers la vue accountVerified
            modelAndView.setViewName("accountVerified");
        }
        /**
         * soit invalide
         */
        else
        {
            modelAndView.addObject("message","Le lien est invalide!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
}

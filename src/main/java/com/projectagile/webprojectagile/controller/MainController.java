package com.projectagile.webprojectagile.controller;

import java.security.Principal;

import com.projectagile.webprojectagile.utils.WebUtils;

import org.springframework.security.core.userdetails.User;
//import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MainController {

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("titre", "Bienvenue");
        model.addAttribute("message", "La page d'acceuil");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        //
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        //

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "adminPage";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String loginPage(Model model){
        return "loginPage";
    }

    @RequestMapping(value="/logoutSuccessful",method=RequestMethod.GET)
    public String logoutSuccessfulPage(Model model){
        model.addAttribute("titre", "Deconnecte");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value="/userInfo",method=RequestMethod.GET)
    public String userInfo(Model model, Principal principal){

        // Après que l'utilisateur s'est bien authentifié
        String userName = principal.getName();

        System.out.println("Nom d'utilisation"+userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);

        return "userInfoPage";
    }

    @RequestMapping(value="/403", method=RequestMethod.GET)
    public String accessDenied(Model model, Principal principal){

        if(principal != null){
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message ="Salut" + principal.getName()//
            +"<br> Vous ne disposez pas une permission pour acceder à cette page!";
            model.addAttribute("message", message);

        }

        return "403Page";

    }

}

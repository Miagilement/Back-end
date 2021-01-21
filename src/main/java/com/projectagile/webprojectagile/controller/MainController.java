package com.projectagile.webprojectagile.controller;


import java.security.Principal;
import com.projectagile.webprojectagile.utils.WebUtilis;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = { "/", "/Welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("titre", "Welcome");
        model.addAttribute("message", "Cela est la page d'acceuil !");
        return "welcomePage";
    }

    @RequestMapping(value ="/admin",method=RequestMethod.GET)
    public String adminPage(Model model, Principal principal){

        User loginedUser=(User) ((Authentication) principal).getPrincipal();
        
        String userInfo = WebUtilis.toString(loginedUser);
        model.addAttribute("Userinfo", userInfo);
        
        return "adminPage";
    
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";

    }

    @RequestMapping(value = "logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model){
        model.addAttribute("Titre", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/UserInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Après une connexion reussi
        String userName = principal.getName();

        System.out.println("Nom d'utilisateur" + userName);

        User loginedUser = (User) (User) ((Authentication) principal).getPrincipal();;

        String userInfo = WebUtilis.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value="/403",method=RequestMethod.GET)
    public String accessDenied(Model model, Principal principal){

        if(principal !=null){

            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtilis.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Salut"+principal.getName()//
            +"<br> Vous ne disposez pas les droits pour acceder a cette page!";
        }
        return "403Page";
    }

}
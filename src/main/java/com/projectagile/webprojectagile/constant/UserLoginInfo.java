package com.projectagile.webprojectagile.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Classe qui permet de répondre à la requête du login
 */

@Data
@AllArgsConstructor
public class UserLoginInfo {

    private String userEmail;

    //Json Web Token : token qui identifie la situation de l'authentification
    private String jwt;

    private List<String> roles;
}

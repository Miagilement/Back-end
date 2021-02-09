package com.projectagile.webprojectagile.enums;

import lombok.Getter;

/**
 * Enumération des types de codes et messages d'erreurs (statuts)
 * suite à l'execution des requêtes HTTP
 */

@Getter
public enum ResultEnum {
    
    NOT_NETWORK(-1, "Seems problem, please try later"),
    SUCCESS(0, "Success"),
    LOGIN_VERIFY_FALL(1, "Login failed"),
    PARAM_VERIFY_FALL(2, "Wrong parameter"),
    AUTH_FAILED(3, "No authentication"),
    DATA_NOT(4, "No related data"),
    DATA_CHANGE(5, "Data no changed"),
    DATA_REPEAT(6, "Data is already existed"),
    USER_NOT(7, "Aucun utilisateur enregistré avec cette adresse mail"),
    USER_WRONG(8, "Le mot de passe est incorrect!"),
    USER_ALREADY_EXIST(9, "Cette adresse email est déjà utilisée!"),
    USER_EMAIL_NOT(10, "Veuillez confirmer votre adresse mail avant d'essayer de vous connecter! Consultez votre boîte mail."),
    LOGIN_TIMEOUT(11, "Token is expired!"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

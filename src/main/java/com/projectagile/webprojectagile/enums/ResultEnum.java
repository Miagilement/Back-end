package com.projectagile.webprojectagile.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    
    NOT_NETWORK(-1, "Seems problem, please try later"),
    SUCCESS(0, "Success"),
    LOGIN_VERIFY_FALL(1, "Login failed"),
    PARAM_VERIFY_FALL(2, "Wrong parameter"),
    AUTH_FAILED(3, "No authentification"),
    DATA_NOT(4, "No data related"),
    DATA_CHANGE(5, "Data no changed"),
    DATA_REPEAT(6, "Data is already existed"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

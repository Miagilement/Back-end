package com.projectagile.webprojectagile.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserLoginInfo {

    private String userEmail;

    private String jwt;

    private List<String> roles;
}

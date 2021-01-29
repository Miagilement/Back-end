package com.projectagile.webprojectagile.enums;


import lombok.Getter;

@Getter
public enum RoleList {
    USER_ENTERPRISE("USER_ENTERPRISE"),
    USER_NORMAL("USER_NORMAL"),
    USER_ADMIN("USER_ADMIN");

    private String roleName;

    RoleList(String roleName) {
        this.roleName = roleName;
    }
}

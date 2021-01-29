package com.projectagile.webprojectagile.vo.req;

import lombok.Data;

@Data
public class UserLoginReqVO extends BaseReqVO {

    private String userEmail;
    private String userPassword;


}

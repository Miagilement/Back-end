package com.projectagile.webprojectagile.vo.req;

import lombok.Data;

/**
 * Class pour requetes VO UserLogin
 * View Object permet de faciliter la récupération de données du front issues de requetes
 */

@Data
public class UserLoginReqVO extends BaseReqVO {

    private String userEmail;
    private String userPassword;


}

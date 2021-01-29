package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.UserNormal;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Class pour request VO Entreprise
 */

@Data
public class UserNormalRegisterReqVO extends BaseReqVO {
    @Valid
    @NotNull(message = "l'utilisateur ne doit pas être nulle")
    private UserNormal userNormal;


}

package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Profile;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Class pour request VO Entreprise
 */

@Data
public class ProfileRegisterReqVO extends BaseReqVO {
    @Valid
    @NotNull(message = "l'utilisateur ne doit pas être nulle")
    private Profile profile;


}

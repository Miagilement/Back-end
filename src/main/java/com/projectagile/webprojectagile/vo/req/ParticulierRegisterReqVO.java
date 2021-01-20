package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Particulier;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Class pour request VO Entreprise
 */

@Data
public class ParticulierRegisterReqVO extends BaseReqVO {
    @Valid
    @NotNull(message = "l'utilisateur ne doit pas être nulle")
    private Particulier particulier;
}

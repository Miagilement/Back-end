package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Enterprise;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Class pour requetes VO Entreprise
 * View Object permet de faciliter la récupération de données du front issues de requetes
 */

@Data
public class EnterpriseReqVO extends BaseReqVO {

    @Valid
    @NotNull(message = "L'entité entreprise ne doit pas être nulle")
    private Enterprise enterprise;
}

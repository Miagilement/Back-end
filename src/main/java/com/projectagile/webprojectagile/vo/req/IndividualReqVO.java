package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Individual;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Class pour requetes VO Individual
 * View Object permet de faciliter la récupération de données du front issues de requetes
 */

@Data
public class IndividualReqVO extends BaseReqVO {
    @Valid
    @NotNull(message = "l'utilisateur ne doit pas être nulle")
    private Individual individual;
}

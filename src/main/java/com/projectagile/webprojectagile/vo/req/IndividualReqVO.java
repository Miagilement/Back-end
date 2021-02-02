package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Individual;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Class pour request VO Entreprise
 */

@Data
public class IndividualReqVO extends BaseReqVO {
    @Valid
    @NotNull(message = "l'utilisateur ne doit pas être nulle")
    private Individual individual;
}
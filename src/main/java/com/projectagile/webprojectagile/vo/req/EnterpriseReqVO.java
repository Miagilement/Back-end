package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Enterprise;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Class pour request VO Entreprise
 */

@Data
public class EnterpriseReqVO extends BaseReqVO {

    @Valid
    @NotNull(message = "L'entité entreprise ne doit pas être nulle")
    private Enterprise enterprise;
}

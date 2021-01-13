package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Enterprise;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class EnterpriseRegisterReqVO extends BaseReqVO {

    @Valid
    @NotNull
    private Enterprise enterprise;
}

package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.vo.req.BaseReqVO;
import lombok.Data;

@Data
public class EnterpriseRegisterReqVO extends BaseReqVO {
    Enterprise enterprise;
}

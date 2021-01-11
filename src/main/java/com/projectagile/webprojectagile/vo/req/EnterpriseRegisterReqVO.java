package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.vo.req.BaseReqVO;
import lombok.Data;

@Data
public class EnterpriseRegisterReqVO extends BaseReqVO {

    private String nameEnterprise;
    private String password;
    private String groupAffiliated;
    private String sectorActivity;
    private String region;
    private String turnOver;
    private String description;
    private String siret;

    public Enterprise toEnterprise(){
        Enterprise enterprise = new Enterprise();
        enterprise.setDescription(this.description);
        enterprise.setGroupAffiliated(this.groupAffiliated);
        enterprise.setNameEnterprise(this.nameEnterprise);
        enterprise.setSiret(this.siret);
        enterprise.setPassword(this.password);
        enterprise.setRegion(this.region);
        enterprise.setSectorActivity(this.sectorActivity);
        enterprise.setTurnOver(this.turnOver);
        return enterprise;
    }
}

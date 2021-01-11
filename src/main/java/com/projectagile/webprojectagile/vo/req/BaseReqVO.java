package com.projectagile.webprojectagile.vo.req;

import lombok.Data;

import java.util.UUID;

/**
 * Basic class for request VO
 */
@Data
public class BaseReqVO {

    private String reqNo;

    private Long timeStamp;

    public BaseReqVO() {
        this.reqNo = UUID.randomUUID().toString();
        this.timeStamp = System.currentTimeMillis();
    }
}

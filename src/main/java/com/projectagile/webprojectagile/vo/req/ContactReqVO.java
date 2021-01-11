package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Contact;
import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
public class ContactReqVO extends BaseReqVO {
    private List<Contact> contacts;
}

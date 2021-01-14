package com.projectagile.webprojectagile.vo.req;

import com.projectagile.webprojectagile.entity.Contact;
import lombok.Data;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;

@Data
public class ContactReqVO extends BaseReqVO {
    @Valid
    private List<Contact> contacts;
}

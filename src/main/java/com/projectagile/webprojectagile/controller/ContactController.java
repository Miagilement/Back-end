package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Contact;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.ContactService;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ContactReqVO;
import com.projectagile.webprojectagile.vo.req.EnterpriseRegisterReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user/enterprise/contact")

public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/addcontact")
    public BaseResVO addcontact (@RequestBody ContactReqVO addcontactReqVO){
        System.out.println(addcontactReqVO.toString());
        List<Contact> contacts = contactService.insertContact(addcontactReqVO.getContacts());

        //TODO Verify data format
        if(contacts != null){
            return ResultVOUtils.success(contacts);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

}

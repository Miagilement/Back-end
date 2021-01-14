package com.projectagile.webprojectagile.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.projectagile.webprojectagile.entity.Contact;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.ContactService;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ContactReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user/enterprise/contact")

public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("/update-contact")
    public BaseResVO updateContact (@Valid @RequestBody ContactReqVO addContactReqVO){
        System.out.println(addContactReqVO.toString());
        List<Contact> contacts = contactService.updateContact(addContactReqVO.getContacts());

        if(contacts != null){
            return ResultVOUtils.success(contacts);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/find-all-contact/{uid}")
    public BaseResVO findAllContact(@PathVariable String uid){
        return ResultVOUtils.success(contactService.getAllContact(uid));
    }

    @PostMapping("/delete-contact/{id}")
    public void deleteContactById(@PathVariable int id){
        contactService.deleteContact(id);
    }

    @PostMapping("/delete-all-contact/{uid}")
    public void deleteAllContact(@PathVariable String uid){
        contactService.deleteAllContact(uid);
    }

}

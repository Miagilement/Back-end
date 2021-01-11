package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ContactDao;
import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.entity.Contact;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDao contactDao;

    @Override
    public List<Contact> insertContact(List<Contact> contacts) {
        return (List<Contact>) contactDao.saveAll(contacts);
    }

}

package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ContactDao;
import com.projectagile.webprojectagile.dao.EnterpriseDao;
import com.projectagile.webprojectagile.entity.Contact;
import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContactServiceImpl implements ContactService {

    ContactDao contactDao;

    @Override
    public List<Contact> updateContact(List<Contact> contacts) {
        return (List<Contact>) contactDao.saveAll(contacts);
    }

    @Override
    public List<Contact> getAllContact(String uid) {
        return (List<Contact>) contactDao.findAllContactByEnterprise(uid);
    }

    @Override
    public void deleteContact(int id) {
        contactDao.deleteById(id);
    }

    @Override
    public void deleteAllContact(String uid) {
        contactDao.deleteContactsByEnterprise_Uid(uid);
    }
}

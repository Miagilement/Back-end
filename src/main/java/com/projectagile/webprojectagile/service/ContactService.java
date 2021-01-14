package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Contact;

import java.awt.*;
import java.util.List;

public interface ContactService {
    List<Contact> updateContact(List<Contact> contacts);
    List<Contact> getAllContact(String uid);
    void deleteContact(int id);
    void deleteAllContact(String uid);
}

package com.projectagile.webprojectagile.service;

import com.projectagile.webprojectagile.entity.Contact;

import java.awt.*;
import java.util.List;

public interface ContactService {
    List<Contact> insertContact(List<Contact> contacts);
}

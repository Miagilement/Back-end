package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Contact;
import org.springframework.data.repository.CrudRepository;


public interface ContactDao extends CrudRepository<Contact, Integer> {
}

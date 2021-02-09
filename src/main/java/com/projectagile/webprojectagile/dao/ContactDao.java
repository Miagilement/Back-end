package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.Contact;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ContactDao extends CrudRepository<Contact, Integer> {

    @Query(value = "SELECT * FROM contact as c WHERE c.uid = ?1", nativeQuery = true)
    List<Contact> findAllContactByEnterprise(String Uid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM contact as c WHERE c.uid = ?1", nativeQuery = true)
    void deleteContactsByEnterprise_Uid(String uid);
}

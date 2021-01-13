package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Contact {

    @Id
    @GeneratedValue
    private int id;

    private String nameContact;
    private String email;
    private String enterpriseUid;

}

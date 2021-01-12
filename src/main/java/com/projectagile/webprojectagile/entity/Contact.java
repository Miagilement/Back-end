package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue
    private int id;

    private String nameContact;
    private String email;
    private String enterpriseUid;

}

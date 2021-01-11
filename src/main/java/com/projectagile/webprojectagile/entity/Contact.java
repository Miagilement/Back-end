package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    @GeneratedValue
    private String id;

    private String nameContact;
    private String email;
    private String enterpriseUid;

}
package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Contact {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Le nom de contact ne doit pas être vide")
    private String nameContact;

    @NotNull(message = "Le email de contact ne doit pas être vide")
    @Email(message = "Le email de contact doit respecter le format d'un eamil")
    private String email;

    //Uid de l'entreprise
    @NotNull(message = "Il faut avoir un uid de l'entreprise")
    @JoinColumn()
    private String uid;
}

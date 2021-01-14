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
    @Email(message = "Le email de contact doit respecter le format d'eamil")
    private String email;

    @Valid
    @NotNull()
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", updatable = false, nullable = false)
    private Enterprise enterprise;

}

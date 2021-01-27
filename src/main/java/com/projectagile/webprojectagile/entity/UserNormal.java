package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "user_normal")
public class UserNormal extends Profile{

    @NotNull(message = "Le champ pseudo ne doit pas être vide")
    private String userName;

    @NotNull(message = "Vous devez choisir votre catégorie professionelle")
    private String userType;
}

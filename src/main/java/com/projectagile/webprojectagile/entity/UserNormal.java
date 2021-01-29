package com.projectagile.webprojectagile.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Entity
@Table
public class UserNormal extends Profile {

    @NotNull(message = "Le champ pseudo ne doit pas être vide")
    private String userName;

    @NotNull(message = "Vous devez choisir votre catégorie professionelle")
    private String userType;


}

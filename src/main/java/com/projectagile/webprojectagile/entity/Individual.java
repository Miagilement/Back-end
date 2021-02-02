package com.projectagile.webprojectagile.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class Individual extends Profile {

    @NotNull(message = "Le champ pseudo ne doit pas être vide")
    private String userName;

    @NotNull(message = "Vous devez choisir votre catégorie professionelle")
    private String userType;



}

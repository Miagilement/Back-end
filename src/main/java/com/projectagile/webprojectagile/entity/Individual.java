package com.projectagile.webprojectagile.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Individual est la classe fille de "Profile"
 * Object Relational Mapping pour la table "individual"
 * Les vérifications sur les données de "Individual" sont faites ici
 * La vérification des données est faite par HiberNate Validator
 * Se réferer à : https://docs.jboss.org/hibernate/annotations/3.4/reference/fr/html/validator.html
 */

@Data
@Entity
@Table
public class Individual extends Profile {



    @NotNull(message = "Le champ pseudo ne doit pas être vide")
    @Length(max = 30, message = "Le pseudo ne doit pas dépasser les 30 caractères")
    private String userName;

    @NotNull(message = "Vous devez choisir votre catégorie professionelle")
    private String userType;



}

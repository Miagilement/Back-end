package com.projectagile.webprojectagile.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Object Relational Mapping pour la table "Enterprise"
 * Les vérifications sur les données de "Enterprise" sont faites ici
 * La vérification des données est faite par HiberNate Validator
 * Se réferer à : https://docs.jboss.org/hibernate/annotations/3.4/reference/fr/html/validator.html
 */

@Data
@MappedSuperclass
public class Profile{

    @Id
    private String uid;

    @Email(message = "L'email de contact doit respecter le format d'un email")
    @NotNull(message = "L'email ne doit pas être vide")
    private String userEmail;

    @NotNull(message = "Le mot de passe ne doit pas être vide")
    @Length(min = 6, message = "Le mot de passe doit être supérieur à 6 caractères")
    private String userPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_role",
            joinColumns = @JoinColumn(name = "uid"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Profile() {
        this.uid = UUID.randomUUID().toString();
    }

}

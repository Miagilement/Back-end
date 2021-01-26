package com.projectagile.webprojectagile.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Object Relational Mapping pour la table "Enterprise"
 * Les vérifications sur les données de "Enterprise" sont faites ici
 * La vérification des données est faite par HiberNate Validator
 * Se réferer à : https://docs.jboss.org/hibernate/annotations/3.4/reference/fr/html/validator.html
 */

@Data
@Entity
@Table
public class Profile {

    @Id
    private String uid;

    @NotNull(message = "Le champ pseudo ne doit pas être vide")
    private String userName;

    @NotNull(message = "Vous devez choisir votre catégorie professionelle")
    private String userType;

    @Email(message = "L'email de contact doit respecter le format d'un email")
    @NotNull(message = "Le champ email ne doit pas être vide")
    private String userEmail;

    @NotNull(message = "Le mot de passe ne doit pas être vide")
    @Length(min = 6, max = 16, message = "Le mot de passe doit compter entre 6 et 16 caractères")
    private String userPassword;

    public Profile(){
        this.uid = UUID.randomUUID().toString();
    }
    
}

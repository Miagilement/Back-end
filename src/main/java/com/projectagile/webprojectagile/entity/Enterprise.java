package com.projectagile.webprojectagile.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
public class Enterprise extends Profile{

    @NotNull(message = "Le nom de l'entreprise ne doit pas être vide")
    private String nameEnterprise;

    private String groupAffiliated;

    @NotNull(message = "Le secteur d'acitivité doit être choisi")
    private String sectorActivity;

    @NotNull(message = "Une région doit être selectionnée")
    private String region;

    @NotNull(message = "Le CA de l'entreprise ne doit pas être vide")
    //Vérifier que le CA contient uniquement les caractère de "0" à "9"
    @Pattern(regexp = "^[0-9]*$", message = "Le CA ne doit pas contenir des lettres ou caractères spéciaux")
    private String turnOver;

    @NotNull(message = "Le description de l'entreprise ne doit pas être vide")
    @Length(max = 300, message = "La description ne doit pas dépasser 300 caractères")
    private String description;

    @NotNull(message = "Le SIRET de l'entreprise ne doit pas être vide")
    //Vérifier que le num SIRET contient uniquement les caractère de "0" à "9"
    @Pattern(regexp = "^[0-9]*$", message = "Le SIRET ne doit pas contenir des lettres ou caractères spéciaux")
    @Length(min = 14, max = 14, message = "Le SIRET doit contenir 14 chiffres")
    @Column(name = "siret", unique = true)
    private String siret;


}

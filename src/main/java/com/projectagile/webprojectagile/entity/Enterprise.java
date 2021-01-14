package com.projectagile.webprojectagile.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@Entity
@Table
public class Enterprise {

    @Id
    private String uid;

    @NotNull(message = "Le nom de l'entreprise ne doit pas être vide")
    private String nameEnterprise;

    @NotNull(message = "Le mot de passe ne doit pas être vide")
    @Length(min = 6, max = 16, message = "Le mot de passe doit compter entre 6 et 16 caractères")
    private String password;

    private String groupAffiliated;

    @NotNull(message = "Le sector d'acitivité doit être choisi")
    private String sectorActivity;

    @NotNull
    private String region;

    @NotNull(message = "Le CA de l'entreprise ne doit pas être vide")
    //Vérifier que le CA contient les caractère de "0" à "9"
    @Pattern(regexp = "^[0-9]*$", message = "Le chiffre d'affaires doit être un nombre supérieur à 0")
    private String turnOver;

    @NotNull(message = "Le description de l'entreprise ne doit pas être vide")
    @Length(max = 300, message = "La description ne doit pas dépasser 300 caractères")
    private String description;

    @NotNull(message = "Le SIRET de l'entreprise ne doit pas être vide")
    //Vérifier que le SIRET contient les caractère de "0" à "9"
    @Pattern(regexp = "^[0-9]*$", message = "Le SIRET doit contenir 14 chiffres")
    @Length(min = 14, max = 14, message = "Le SIRET doit contenir 14 chiffres")
    @Column(name = "siret", unique = true)
    private String siret;

    public Enterprise() {
        this.uid = UUID.randomUUID().toString();
    }
}

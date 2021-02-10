package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Object Relational Mapping pour la table "role"
 * La table role enregistre les types de roles existants
 * Les vérifications sur les données de "Role" sont faites ici
 * La vérification des données est faite par HiberNate Validator
 * Se réferer à : https://docs.jboss.org/hibernate/annotations/3.4/reference/fr/html/validator.html
 */

@Data
@Entity
// définition d'une contraintre : le nom d'un role doit être unique (ne pas avoir de doublons)
@Table(uniqueConstraints = { //
                @UniqueConstraint(name = "TAG_FILTER_UNIQUE_CONSTRAINT", columnNames = "tag_name") })

public class ForumTag {
     
    @Id
    @GeneratedValue
    private Long tagId;

    @Column(name="tag_name", nullable = false)
    private String tagName;

}


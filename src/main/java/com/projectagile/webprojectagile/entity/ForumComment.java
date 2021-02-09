package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Object Relational Mapping pour la table "forum_comment"
 * Les vérifications sur les données de "Forum-comment" sont faites ici
 * La vérification des données est faite par HiberNate Validator
 * Se réferer à : https://docs.jboss.org/hibernate/annotations/3.4/reference/fr/html/validator.html
 */

@Data
@Entity
@Table
public class ForumComment {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Le subjectId ne doit pas être nul pour un commentaire")
    private int subjectId;

    @NotNull(message = "Le commentaire de doit pas être vide")
    private String text;

    @NotNull(message = "Le authorId doit être renseigné pour le commentaire")
    private String authorId;

    private String authorName;

    private Date dateComment;

    private Date dateLastModified;

    public ForumComment() {
        this.dateLastModified = new Date();
    }
}

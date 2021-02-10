package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;
import java.util.List;
import java.util.Date;

/**
 * Object Relational Mapping pour la table "forum_subject"
 * Les vérifications sur les données de "Forum-subject" sont faites ici
 * La vérification des données est faite par HiberNate Validator
 * Se réferer à : https://docs.jboss.org/hibernate/annotations/3.4/reference/fr/html/validator.html
 */

@Data
@Entity
@Table
public class ForumSubject {

    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(targetEntity = ForumTag.class, fetch = FetchType.EAGER)
    @JoinTable(name="subject_tag")
    private List<ForumTag> forumTagList;

    @NotNull(message = "Le titre du sujet dans le forum doit être renseigné")
    @Length(max = 70, message = "Le titre du sujet dans le forum ne doit pas dépasser 70 caractères")
    private String title;

    @NotNull(message = "Le sujet dans le forum ne doit pas être vide")
    private String text;

    @NotNull(message = "Le authorId doit être renseigné pour le sujet")
    private String authorId;

    private String authorName;

    private Date datePost;

    private Date dateLastModified;

    public ForumSubject() {
        this.dateLastModified = new Date();
    }
}

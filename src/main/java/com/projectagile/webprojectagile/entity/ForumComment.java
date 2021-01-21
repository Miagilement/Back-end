package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table
public class ForumComment {

    @Id
    @GeneratedValue
    private int id;

    private int subject_id;

    private String text;

    private String author_id;

    private Date dateComment;

    private Date dateLastModified;

    public ForumComment() {
        this.dateLastModified = new Date();
    }
}

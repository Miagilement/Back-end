package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
import java.util.Date;

@Data
@Entity
@Table
public class ForumSubject {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String text;

    private String authorId;

    private Date datePost;

    private Date dateLastModified;

    public ForumSubject() {
        this.dateLastModified = new Date();
    }
}
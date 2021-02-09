package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@Data
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @GeneratedValue
    @Column
    private long tokenid;

    @Column
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Profile.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "uid")
    private Profile profile;

    public ConfirmationToken(Profile profile) {
        this.profile = profile;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

}

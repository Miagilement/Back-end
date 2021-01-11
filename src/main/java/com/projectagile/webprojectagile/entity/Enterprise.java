package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "Enterprise")
public class Enterprise {

    @Id
    private String uid;

    private String nameEnterprise;

    private String password;

    private String groupAffiliated;

    private String sectorActivity;

    private String region;

    private String turnOver;

    private String description;

    private String siret;

    public Enterprise() {
        this.uid = UUID.randomUUID().toString();
    }
}

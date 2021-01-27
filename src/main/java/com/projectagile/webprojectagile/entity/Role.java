package com.projectagile.webprojectagile.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "role_name") })
public class Role {
     
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Long roleId;
 
    @Column(name = "role_name",length = 30, nullable = false)
    private String roleName;

}

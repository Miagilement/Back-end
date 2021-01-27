package com.projectagile.webprojectagile.entity;

import javax.persistence.*;

@Entity
@Table( //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "uid", "role_id" }) })
public class UserRole {
 
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "role_id", nullable = false)
    private String roleId;

}

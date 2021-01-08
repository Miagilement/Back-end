package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TESTCLASS")
public class TestClass {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "text")
    private String text;

    public TestClass(String text) {
        this.text = text;
    }

}

package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "testClass")
public class TestClass {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String text;

    public TestClass(String text) {
        this.text = text;
    }

}

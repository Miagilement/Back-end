package com.projectagile.webprojectagile.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Entity
@Table
public class TestClass {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Text can't not be empty")
    private String text;

    public TestClass(String text) {
        this.text = text;
    }

}

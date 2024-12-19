package com.management.student.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "student", schema = "public")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="index")
    private String indexNo;

    @Column(name="name")
    private String name;

    @Column(name="dob")
    private Date dob;

    @Column(name="gpa")
    private Float gpa;

}

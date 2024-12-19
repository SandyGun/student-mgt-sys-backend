package com.management.student.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String indexNo;
    private String name;
    private Date dob;
    private Float gpa;
}

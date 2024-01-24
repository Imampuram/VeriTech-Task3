package com.edu.qt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "qtms_faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    String name;
    @Column(name = "course_teaching")
    String course_teaching;
    @Column(name = "email")
    String email;
    @Column(name = "mobile")
    int mobile;
    @Column(name = "qualification")
    String qualification;
    @Column(name = "interviewed_on")
    String interviewed_on;
    @Column(name = "location")
    String location;
    @Column(name = "training_mode")
    String training_mode;
    @Column(name = "available_timing")
    String available_timing;
    @Column(name = "feedback")
    String feedback;
    @Column(name = "interviewer_name")
    String interviewer_name;
    @Column(name = "interviewer_contact")
    String interviewer_contact;
    @Column(name = "remarks")
    String remarks;
    @Column(name = "teaching_experience")
    String teaching_experience;
}

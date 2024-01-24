package com.edu.qt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="Course")
public class Course{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    String name;

    @Column(name = "duration")
    int  duration;

    @Column(name = "fee")
    int  fee;
}

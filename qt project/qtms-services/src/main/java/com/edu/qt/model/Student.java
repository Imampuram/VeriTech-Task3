package com.edu.qt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity(name = "qtms_student")
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_generator")
    @SequenceGenerator(name="student_generator", sequenceName = "qtms_stud_seq")
    @Column(name = "id")
    Integer id ;

    @Column(name = "name")
    String name ;

    @Column(name = "mobile")
    String mobile ;

    @Column(name = "email")
    String email ;

    @Column(name = "course")
    String course ;

    @Column(name = "status")
    String status ;

    @Column(name ="enquired_on")
    Date  enquiredOn ;

    @Column(name="FIRST_REMAINDER_MAIL_SENT")
    String  firstEmailRemainder ;

    @Column(name="FIRST_REMAINDER_SMS_SENT")
    String  firstSMSRemainder ;



}

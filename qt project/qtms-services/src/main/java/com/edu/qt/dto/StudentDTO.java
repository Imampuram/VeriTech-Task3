package com.edu.qt.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class StudentDTO {

    String name ;
    String mobile ;
    String email ;
    String course ;
    String status ;
    Date enquiredOn ;
    String  firstEmailRemainder ;
    String  firstSMSRemainder ;


}

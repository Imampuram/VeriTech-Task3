package com.edu.qt.controller;


import com.edu.qt.dto.CourseDTO;
import com.edu.qt.model.Course;
import com.edu.qt.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class
CourseController {

    @Autowired
    CourseService courseService;

    ModelMapper modelMapper = new ModelMapper() ;

    @GetMapping(value = "/course/all", produces = "application/json")
    public List<CourseDTO> fetchAllCourse(){
        List<Course> courseList =courseService.fetchAllCourse();
        List<CourseDTO> courses = Arrays.asList(modelMapper.map(courseList, CourseDTO[].class));
        System.out.println("courses=="+courses.get(0).getName());
        return courses;
    }

}

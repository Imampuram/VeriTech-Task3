package com.edu.qt.service;

import com.edu.qt.model.Course;
import com.edu.qt.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> fetchAllCourse(){
        List<Course> course = (List<Course>)courseRepository.findAll();
        return course;
    }
}

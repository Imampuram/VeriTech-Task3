package com.edu.qt.controller;


import com.edu.qt.dto.FacultyDTO;
import com.edu.qt.model.Faculty;
import com.edu.qt.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

public class FaultyController {

    FacultyService facultyService;

    ModelMapper modelMapper = new ModelMapper();

    public List<FacultyDTO> fetchAllFaculty(){
        System.out.println("In controller...");
        List<Faculty> facultyList = facultyService.fetchAllFacultyService();
        List<FacultyDTO> faculty = Arrays.asList(modelMapper.map(facultyList, FacultyDTO[].class));
        return faculty;
    }
    // Create Faculty
      @PostMapping(value = "/faulty/create" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<FacultyDTO> createStudent(@RequestBody FacultyDTO facultyDTO) {
        System.out.println("In controller...");
        List<Faculty> facultyList =  facultyService.fetchAllFacultyService();
        List<FacultyDTO> faculty = Arrays.asList(modelMapper.map(facultyList,FacultyDTO[].class));
        return faculty ;
    }
}

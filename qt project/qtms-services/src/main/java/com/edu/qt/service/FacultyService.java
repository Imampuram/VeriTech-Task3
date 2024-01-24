package com.edu.qt.service;

import com.edu.qt.model.Faculty;
import com.edu.qt.repository.FacultyRepository;

import java.util.List;

public class FacultyService {

    FacultyRepository facultyRepository;

    public List<Faculty> fetchAllFacultyService() {
        List<Faculty> students = (List<Faculty>) facultyRepository.findAll();
        System.out.println("no of students==" + students.size());
        return students;
    }

   /* @Override
    public FacultyService
    updateFacultyService(FacultyService facultyService,
                     Long facultyId){
        return facultyRepository(updateFacultyService(facultyService,facultyId));
    }*/

}

package com.edu.qt.repository;

import com.edu.qt.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
                 Student  findByMobile(String mobile);
                 List<Student> findByNameContains(String name);

                 List<Student> findByStatus(String status);
}

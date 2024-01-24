package com.edu.qt.controller;

import com.edu.qt.dto.StudentDTO;
import com.edu.qt.model.Student;
import com.edu.qt.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class StudentController {

    @Autowired
    StudentService studentService ;

    // @Autowired
    ModelMapper modelMapper = new ModelMapper() ;


    @GetMapping(value = "/student/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> fetchAllUsers() {
        System.out.println("In controller...");
        List<Student> studentList =  studentService.fetchAllStudents();
        List<StudentDTO> students = Arrays.asList(modelMapper.map(studentList,StudentDTO[].class));
        return students ;
    }

    @GetMapping(value = "/student/name/{name}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> fetchStudentByName(@PathVariable("name") String name) {
        System.out.println("Fetching students by name ...");
        List<Student> studentList =  studentService.fetchStudentByName(name);

        List<StudentDTO> students = Arrays.asList(modelMapper.map(studentList,StudentDTO[].class));
        return students ;
    }

    @GetMapping(value = "/student/mobile/{mobile}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public StudentDTO fetchStudentByMobile(@PathVariable("mobile") String mobile) {
        System.out.println("Fetching students by mobile...");

        Student student =  studentService.fetchStudentByMobile(mobile);
        System.out.println("student=="+student);
        StudentDTO studentDTO = new StudentDTO();
        if(student!=null) {
            studentDTO = modelMapper.map(student, StudentDTO.class);
        }
        return studentDTO ;
    }
    @GetMapping(value = "/student/enquiry/{status}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> fetchStudentsByStatus(@PathVariable("status") String status) {
        System.out.println("Fetching students by status...");
        List<StudentDTO> students = Arrays.asList(modelMapper.map(studentService.fetchStudentByStatus(status),StudentDTO[].class));
        return students ;
    }
    @PutMapping(value = "/student/send/mail" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendMail(@RequestBody StudentDTO studentDTO) {
         System.out.println("Sending Mail...");
         if(studentService.sendMail(studentDTO.getEmail())) {
             System.out.println("Going to update Mail Flag...");
             Student student  = studentService.fetchStudentByMobile(studentDTO.getMobile());
             student.setFirstEmailRemainder("Y");
             studentService.persistStudent(student);
             System.out.println("Mail Falg updated Successfulyy..");
             return ResponseEntity.ok().body("Mail Sent Successfully...");
         }else {
            return ResponseEntity.ok().body("Theere was some error in sending Mail");
        }
    }
    @PostMapping(value = "/student/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  createStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println("name of the student=="+studentDTO.getName());
        Student student = modelMapper.map(studentDTO,Student.class);
        studentService.persistStudent(student);
        return ResponseEntity.ok().body("Student Registered Successfully.");
    }
    @PutMapping(value = "/student/update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  updateStudent(@RequestBody StudentDTO studentDTO) {
        Student student  = studentService.fetchStudentByMobile(studentDTO.getMobile());
        studentService.modifyStudent(generateStudent(studentDTO,student));
        return ResponseEntity.ok().body("Student Details Modified Successfully.");
    }
    private Student  generateStudent(StudentDTO studentDTO,Student student) {
        student.setCourse(studentDTO.getCourse());
        student.setEmail(studentDTO.getEmail());
        student.setMobile(studentDTO.getMobile());
        student.setStatus(studentDTO.getStatus());
        student.setName(studentDTO.getName());
        return student ;
    }

}

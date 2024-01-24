package com.edu.qt.service;

import com.edu.qt.repository.StudentRepository;
import com.edu.qt.model.Student;
import com.edu.qt.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


       @Autowired
       StudentRepository studentRepository ;

       private final String  from = "baddechandu999@gmail.com" ;
       public List<Student> fetchAllStudents(){
           List<Student> students = (List<Student>)studentRepository.findAll();
           return students;
       }
    public boolean  sendMail(String toMail){
           boolean sentSts =  true ;
           try {
               MailUtil.sendMail(from, toMail, "testing", "welcome to QT..");

           }catch(Exception e) {
               e.printStackTrace();
               sentSts = false ;
           }
        return sentSts;
    }
    public Student fetchStudentByMobile(String mobileno){
        return studentRepository.findByMobile(mobileno);
    }
    public List<Student> fetchStudentByStatus(String status){
        return studentRepository.findByStatus(status);
    }
    public List<Student> fetchStudentByName(String name){
        List<Student>  students =  studentRepository.findByNameContains(name);
        System.out.println("no of students=="+students.size());
        return students ;
    }
    public void  persistStudent(Student student){
          studentRepository.save(student);

    }
    public void  modifyStudent(Student student) {

        studentRepository.save(student);

    }
}

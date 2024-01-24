package com.edu.qt.controller;


import com.edu.qt.dto.UserDTO;
import com.edu.qt.model.User;
import com.edu.qt.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService ;

   // @Autowired
    ModelMapper modelMapper = new ModelMapper() ;

    @GetMapping(value = "/users/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> fetchAllUsers() {
          System.out.println("In controller...");
          List<User> userList =  userService.fetchAllUsers();
          List<UserDTO> users = Arrays.asList(modelMapper.map(userList,UserDTO[].class));
          return users ;
    }



}

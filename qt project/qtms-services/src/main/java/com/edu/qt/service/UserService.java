package com.edu.qt.service;


import com.edu.qt.model.User;
import com.edu.qt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    public List<User> fetchAllUsers() {
        List<User> users = (List<User>)userRepository.findAll();
        return  users;
        //return generateUsers();

    }
    private List<User>  generateUsers() {
         List<User> users = new ArrayList<>();
         User user = new User();
         user.setId(1);
         user.setName("pavan");
         user.setPass("pass");
         users.add(user);
          return users ;
    }
}

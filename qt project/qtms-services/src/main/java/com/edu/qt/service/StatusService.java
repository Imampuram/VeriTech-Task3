package com.edu.qt.service;



import com.edu.qt.model.Status;
import com.edu.qt.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public List<Status> fetchAll(){
        List<Status>  registrationStatusList = (List<Status>)statusRepository.findStatusByCodedesc("student_reg_status");
        System.out.println("size=="+registrationStatusList.size());
        return registrationStatusList;
    }
}


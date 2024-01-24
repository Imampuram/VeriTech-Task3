package com.edu.qt.controller;



import com.edu.qt.dto.StatusDTO;
import com.edu.qt.model.Status;
import com.edu.qt.service.StatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StatusController {

    @Autowired
    StatusService statusService;

    //@Autowired
    ModelMapper modelMapper = new ModelMapper() ;

    @GetMapping(value = "/student/registration/status/all", produces = "application/json")
    public List<StatusDTO> fetchAll(){
        List<Status> statusList =statusService.fetchAll();
        List<StatusDTO> statusDTOList = Arrays.asList(modelMapper.map(statusList, StatusDTO[].class));
        return statusDTOList;
    }

}

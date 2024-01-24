package com.edu.qt.repository;


import com.edu.qt.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends CrudRepository<Status,Long> {

     List<Status>   findStatusByCodedesc(String desc);



}


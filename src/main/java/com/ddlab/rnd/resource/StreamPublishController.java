package com.ddlab.rnd.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.service.PublisherService;

@RestController
public class StreamPublishController {
    
    @Autowired
    PublisherService pubServie;
    
    @PostMapping("/publish")
    public String publishEvent(@RequestBody Employee emp) {
        pubServie.sendEmpInfo(emp);
        return "Message Posted Successfully";
    }

}

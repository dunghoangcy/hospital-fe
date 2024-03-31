package com.lsd.web.controller;


import com.lsd.web.persistance.model.InformationHeaderModel;
import com.lsd.web.service.InformationHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("information")
@CrossOrigin
public class InformationController {
    @Autowired
    private InformationHeaderService informationHeaderService;

    @GetMapping("")
    public List<InformationHeaderModel> findAll() {
        return new ResponseEntity<>(informationHeaderService.findAll(), HttpStatus.OK).getBody();
    }
}

package com.lsd.web.controller;

import com.lsd.web.exception.ErrorCode;
import com.lsd.web.exception.ErrorMessageLoader;
import com.lsd.web.exception.WebException;
import com.lsd.web.persistance.model.FilterPatientResponse;

import com.lsd.web.persistance.model.MedicalModel;
import com.lsd.web.persistance.model.PatientModel;

import com.lsd.web.persistance.model.PatientRequest;
import com.lsd.web.service.MedicalService;
import com.lsd.web.service.PatientService;
import com.lsd.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private MedicalService medicalService;

    @Autowired
    private Common common;

    @GetMapping("")
    public List<PatientModel> findAll() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK).getBody();
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<PatientModel> edit(@ModelAttribute PatientModel patientModel) {
        if(!common.isValidDateFormatPatient(patientModel.getDateExamination())){
            throw new WebException(ErrorCode.DATE_VALID, ErrorMessageLoader.getMessage("LSD-YYYYMMDD"));
        }
       if(patientService.findById(patientModel.getId()) == null){
            throw new WebException(ErrorCode.NOT_FOUND, patientModel.getId());
        }
        else {
            PatientModel patientModel1 = patientService.edit(patientModel);
            return new ResponseEntity<>(patientModel1, HttpStatus.CREATED);
        }

    }

    @PostMapping("/add")
    public Object add(@ModelAttribute PatientModel patientModel){
        if(!common.isValidDateFormatPatient(patientModel.getDateExamination())){
            throw new WebException(ErrorCode.DATE_VALID, ErrorMessageLoader.getMessage("LSD-YYYYMMDD"));
        }
        PatientModel patientModel1 = patientService.add(patientModel);
        return new ResponseEntity<>(patientModel1, HttpStatus.CREATED);


    }

    @PostMapping("/findPatient")
    public ResponseEntity<FilterPatientResponse> findPatient(@RequestBody PatientRequest request) {
        return new ResponseEntity<>(patientService.findPatient(request), HttpStatus.OK);
    }

//    Tìm kiếm danh sách bệnh án của bệnh nhân
    @GetMapping("/getMedical/{patientId}")
    public ResponseEntity<ArrayList<MedicalModel>> getMedicalByPatientId(@PathVariable("patientId")Long patientId) {
        return new ResponseEntity<>(medicalService.getMedicalByPatientId(patientId) , HttpStatus.OK);
    }
}

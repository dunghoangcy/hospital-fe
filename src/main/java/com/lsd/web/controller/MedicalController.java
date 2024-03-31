package com.lsd.web.controller;

import com.lsd.web.persistance.model.MedicalModel;
import com.lsd.web.service.MedicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medical")
@CrossOrigin
@RequiredArgsConstructor
public class MedicalController {
    private final MedicalService medicalService;


    // Tìm kiếm bệnh án theo id bệnh án
    @GetMapping("/{id}")
    public ResponseEntity<MedicalModel> getMedicalById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(medicalService.getMedicalById(id), HttpStatus.OK);
    }


}

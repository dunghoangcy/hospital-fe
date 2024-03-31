package com.lsd.web.persistance.mapper;

import com.lsd.web.persistance.entity.Medical;
import com.lsd.web.persistance.entity.Statistic;
import com.lsd.web.persistance.model.MedicalModel;
import com.lsd.web.persistance.repository.MedicailRepository;
import com.lsd.web.persistance.repository.StatisticRepository;
import com.lsd.web.service.StatisticService;
import com.lsd.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MedicalAdapter {
    public static MedicalModel medicalModel(Medical medical){
        return new MedicalModel().builder()
                .id(medical.getId())
                .patientId(medical.getPatientId())
                .nameDoctor(medical.getNameDoctor())
                .dateOfInstallation(medical.getDateOfInstallation())
                .dateOfBrackets(medical.getDateOfBrackets())
                .targetNote(medical.getTargetNote())
                .appointment(medical.getAppointment())
                .preoperative(medical.getPreoperative())
                .status(medical.getStatus())
                .createdAt(medical.getCreatedAt())
                .build();
    }
    public static Medical medical(MedicalModel medicalModel){
        return new Medical().builder()
                .id(medicalModel.getId())
                .patientId(medicalModel.getPatientId())
                .nameDoctor(medicalModel.getNameDoctor())
                .dateOfInstallation(medicalModel.getDateOfInstallation())
                .dateOfBrackets(medicalModel.getDateOfBrackets())
                .targetNote(medicalModel.getTargetNote())
                .appointment(medicalModel.getAppointment())
                .preoperative(medicalModel.getPreoperative())
                .status(medicalModel.getStatus())
                .createdAt(medicalModel.getCreatedAt())
                .build();
    }
}

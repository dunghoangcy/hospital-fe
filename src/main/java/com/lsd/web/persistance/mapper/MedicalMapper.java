package com.lsd.web.persistance.mapper;

import com.lsd.web.persistance.entity.Medical;
import com.lsd.web.persistance.model.MedicalModel;

public class MedicalMapper {
    public static Medical toMedical(MedicalModel model){
        return Medical.builder()
                .id(model.getId())
                .patientId(model.getPatientId())
                .nameDoctor(model.getNameDoctor())
                .dateOfInstallation(model.getDateOfInstallation())
                .dateOfBrackets(model.getDateOfBrackets())
                .targetNote(model.getTargetNote())
                .preoperative(model.getPreoperative())
                .appointment(model.getAppointment())
                .status(model.getStatus())
                .createdAt(model.getCreatedAt())
                .build();

    }
    public static MedicalModel toMedicalModel(Medical medical){
        return MedicalModel.builder()
                .id(medical.getId())
                .patientId(medical.getPatientId())
                .nameDoctor(medical.getNameDoctor())
                .dateOfInstallation(medical.getDateOfInstallation())
                .dateOfBrackets(medical.getDateOfBrackets())
                .targetNote(medical.getTargetNote())
                .preoperative(medical.getPreoperative())
                .appointment(medical.getAppointment())
                .status(medical.getStatus())
                .createdAt(medical.getCreatedAt())
                .build();

    }

}

package com.lsd.web.persistance.mapper;


import com.lsd.web.persistance.entity.Patient;
import com.lsd.web.persistance.model.PatientModel;
import com.lsd.web.util.Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PatientAdapter {
    private Patient patient;

    public PatientAdapter(Patient patient) {this.patient = patient;}


    public static PatientModel patientModel(Patient patient) {

        return new PatientModel().builder()
                .id(patient.getId())
                .dateExamination(patient.getDateExamination().toString())
                .gender(patient.getGender())
                .fullName(patient.getFullName())
                .yearBirthday(patient.getYearBirthday())
                .phone(patient.getPhone())
                .inputDataBy(patient.getInputDataBy())
                .inputDataInvi(patient.getInputDataInvi())
                .analysisOfCustomer(patient.getAnalysisOfCustomer())
                .confirmOfCustomer(patient.getConfirmOfCustomer())
                .address(patient.getAddress())
                .statusPatient(patient.getStatusPatient())
                .status(patient.getStatus())
                .createdAt(patient.getCreatedAt())
                .updatedAt(patient.getUpdatedAt())
                .build();
    }

    public static Patient patientUpdate(PatientModel patientModel) {
        return new Patient().builder()
                .id(patientModel.getId())
                .dateExamination(Common.convertStringToDate(patientModel.getDateExamination()))
                .gender(patientModel.getGender())
                .fullName(patientModel.getFullName())
                .yearBirthday(patientModel.getYearBirthday())
                .phone(patientModel.getPhone())
                .inputDataBy(patientModel.getInputDataBy())
                .inputDataInvi(patientModel.getInputDataInvi())
                .analysisOfCustomer(patientModel.getAnalysisOfCustomer())
                .confirmOfCustomer(patientModel.getConfirmOfCustomer())
                .address(patientModel.getAddress())
                .statusPatient(patientModel.getStatusPatient())
                .status(patientModel.getStatus())
                .updatedAt(patientModel.getUpdatedAt())
                .build();
    }

    public static Patient patient(PatientModel patientModel) {
        return new Patient().builder()
                .id(patientModel.getId())
                .dateExamination(Common.convertStringToDate(patientModel.getDateExamination()))
                .gender(patientModel.getGender())
                .fullName(patientModel.getFullName())
                .yearBirthday(patientModel.getYearBirthday())
                .phone(patientModel.getPhone())
                .inputDataBy(patientModel.getInputDataBy())
                .inputDataInvi(patientModel.getInputDataInvi())
                .analysisOfCustomer(patientModel.getAnalysisOfCustomer())
                .confirmOfCustomer(patientModel.getConfirmOfCustomer())
                .address(patientModel.getAddress())
                .statusPatient(patientModel.getStatusPatient())
                .status(patientModel.getStatus())
                .createdAt(patientModel.getCreatedAt())
                .updatedAt(patientModel.getUpdatedAt())
                .build();
    }
    public static Patient toPatient(PatientModel model){
        return Patient.builder()
                .id(model.getId())
                .dateExamination(Common.convertStringToDate(model.getDateExamination()))
                .gender(model.getGender())
                .fullName(model.getFullName())
                .yearBirthday(model.getYearBirthday())
                .inputDataInvi(model.getInputDataInvi())
                .analysisOfCustomer(model.getAnalysisOfCustomer())
                .confirmOfCustomer(model.getConfirmOfCustomer())
                .address(model.getAddress())
                .statusPatient(model.getStatusPatient())
                .status(model.getStatus())
                .createdAt(model.getCreatedAt())
                .updatedAt(model.getUpdatedAt())
                .build();
    }

}

package com.lsd.web.service;
import com.lsd.web.persistance.model.FilterPatientResponse;
import com.lsd.web.persistance.model.PatientModel;
import com.lsd.web.persistance.model.PatientRequest;


public interface PatientService extends BaseService<PatientModel, Long> {
    FilterPatientResponse findPatient(PatientRequest request);
}

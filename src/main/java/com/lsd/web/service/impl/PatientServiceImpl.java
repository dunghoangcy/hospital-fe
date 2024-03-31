package com.lsd.web.service.impl;

import com.lsd.web.exception.ErrorCode;
import com.lsd.web.exception.ErrorMessageLoader;
import com.lsd.web.exception.WebException;
import com.lsd.web.persistance.entity.Patient;
import com.lsd.web.persistance.mapper.PatientAdapter;
import com.lsd.web.persistance.model.FilterPatientResponse;
import com.lsd.web.persistance.model.PatientModel;
import com.lsd.web.persistance.model.PatientRequest;
import com.lsd.web.persistance.model.PatientResponse;
import com.lsd.web.persistance.repository.PatientRepository;
import com.lsd.web.service.PatientService;
import com.lsd.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public PatientModel add(PatientModel p) {
        if(p.getFullName().isEmpty()){
            throw new WebException(ErrorCode.REQUEST_BAD, ErrorMessageLoader.getMessage("LSD-NAME-PATIENT-NULL"));
        }
        if(p.getAddress().isEmpty()){
            throw new WebException(ErrorCode.REQUEST_BAD, ErrorMessageLoader.getMessage("LSD-ADDRESS-NULL"));
        }
        if(!Common.isValidPhone(String.valueOf(p.getPhone()))){
            throw new WebException(ErrorCode.REQUEST_BAD,ErrorMessageLoader.getMessage("LSD-PHONE-VAlID"));
        }
        if (p.getYearBirthday() < 1900 || p.getYearBirthday() > Common.getYearNow()) {
            throw new WebException(ErrorCode.REQUEST_BAD, ErrorMessageLoader.getMessage("LSD-YEAR-BIRTHDAY-VALID"));
        };
        if (p.getYearBirthday() == null) {
            throw new WebException(ErrorCode.REQUEST_BAD,ErrorMessageLoader.getMessage("LSD-YEAR-BIRTHDAY-NULL"));
        };
        if (p.getGender() == null) {
            throw new WebException(ErrorCode.REQUEST_BAD,ErrorMessageLoader.getMessage("LSD-GENDER-NULL"));
        };

        try {
            Patient patient = PatientAdapter.patient(p);
            Patient save = patientRepository.save(patient);
            PatientModel patientModel = PatientAdapter.patientModel(save);
            return  patientModel;
        }catch(Exception ex){
            throw new WebException(ErrorCode.INTERNAL_SERVER);
        }
    }
    @Override
    public List<PatientModel> findAll() {
        List<Patient> list = patientRepository.findAll();
        return list.stream().map(PatientAdapter::patientModel).collect(Collectors.toList());
    }

    @Override
    public PatientModel findById(Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient == null){
            throw new WebException(ErrorCode.NOT_FOUND);
        }
        PatientModel patientModel = PatientAdapter.patientModel(patient);
        return patientModel;
    }

    @Override
    public PatientModel edit(PatientModel p) {

        if(p.getFullName().isEmpty()){
            throw new WebException(ErrorCode.REQUEST_BAD, ErrorMessageLoader.getMessage("LSD-NAME-PATIENT-NULL"));
        }
        if(p.getAddress().isEmpty()){
            throw new WebException(ErrorCode.REQUEST_BAD, ErrorMessageLoader.getMessage("LSD-ADDRESS-NULL"));
        }
        if(!Common.isValidPhone(String.valueOf(p.getPhone()))){
            throw new WebException(ErrorCode.REQUEST_BAD,ErrorMessageLoader.getMessage("LSD-PHONE-VAlID"));
        }
        if (p.getYearBirthday() < 1900 || p.getYearBirthday() > Common.getYearNow()) {
            throw new WebException(ErrorCode.REQUEST_BAD, ErrorMessageLoader.getMessage("LSD-YEAR-BIRTHDAY-VALID"));
        };
        if (p.getYearBirthday() == null) {
            throw new WebException(ErrorCode.REQUEST_BAD,ErrorMessageLoader.getMessage("LSD-YEAR-BIRTHDAY-NULL"));
        };
        if (p.getGender() == null) {
            throw new WebException(ErrorCode.REQUEST_BAD,ErrorMessageLoader.getMessage("LSD-GENDER-NULL"));
        };

        try {
            Patient patient = PatientAdapter.patientUpdate(p);
            patient.setUpdatedAt(Common.getDateNow());

            Patient save = patientRepository.save(patient);

            PatientModel patientModel = PatientAdapter.patientModel(save);

            return patientModel;
        }catch (Exception ex){
            throw new WebException(ErrorCode.INTERNAL_SERVER);
        }
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }


    public FilterPatientResponse findPatient(PatientRequest request) {
        try {
            if(request.getPage() == null || request.getPage() < 0) {
                throw new IllegalArgumentException(ErrorCode.ERROR_PAGE);
            }

            if(request.getPageSize() == null || request.getPageSize() < 1) {
                throw new IllegalArgumentException(ErrorCode.ERROR_PAGE_SIZE);
            }

            Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize());
            Page<PatientResponse> results = this.patientRepository.findPatientByPhoneAndFullName(
                    pageable,
                    request.getKeySearch()
            );

            FilterPatientResponse response = new FilterPatientResponse();
            response.setListRecord(results.toList());
            response.setTotalRecord(results.getNumberOfElements());
            return response;
        } catch (IllegalArgumentException e) {
            throw new WebException(ErrorCode.INTERNAL_SERVER,e.getMessage());
        }
    }
}

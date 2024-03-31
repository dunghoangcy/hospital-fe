package com.lsd.web.service;


import com.lsd.web.persistance.model.MedicalModel;

import java.util.ArrayList;


public interface MedicalService extends BaseService<MedicalModel, Long>{
    MedicalModel getMedicalById(Long id);
    ArrayList<MedicalModel> getMedicalByPatientId(Long patientId);
}



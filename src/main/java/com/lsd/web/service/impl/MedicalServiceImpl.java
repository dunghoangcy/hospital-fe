package com.lsd.web.service.impl;

import com.lsd.web.exception.ErrorCode;
import com.lsd.web.exception.WebException;
import com.lsd.web.persistance.entity.Medical;
import com.lsd.web.persistance.entity.Statistic;
import com.lsd.web.persistance.mapper.MedicalAdapter;
import com.lsd.web.persistance.model.InformationDetailModel;
import com.lsd.web.persistance.model.InformationHeaderModel;
import com.lsd.web.persistance.model.MedicalModel;
import com.lsd.web.persistance.repository.MedicalRepository;
import com.lsd.web.persistance.repository.StatisticsRepository;
import com.lsd.web.service.InformationDetailService;
import com.lsd.web.service.InformationHeaderService;
import com.lsd.web.service.MedicalService;
import com.lsd.web.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalServiceImpl implements MedicalService {
    private final MedicalRepository medicalRepository;
    private final StatisticsRepository statisticsRepository;
    private final InformationDetailService informationDetailService;
    private final InformationHeaderService informationHeaderService;

    @Override
    public MedicalModel getMedicalById(Long id) {
        Optional<Medical> opt = medicalRepository.findById(id);
        if(opt.isEmpty()){
            throw new WebException(ErrorCode.NOT_FOUND);
        }else{
            ArrayList<Statistic> statistics = statisticsRepository.findStatisticByIdMedical(id);
            ArrayList<InformationDetailModel> informationDetailModels = new ArrayList<>();
            informationDetailModels = informationDetailService.getDetailHavHeader();
            ArrayList<InformationDetailModel> finalInformationDetailModelArrayList = informationDetailModels;
            statistics.forEach(i ->{
                InformationDetailModel informationDetailModel = informationDetailService.findById(i.getIdDetail());
                finalInformationDetailModelArrayList.add(informationDetailModel);
            });
            MedicalModel model = MedicalAdapter.medicalModel(opt.get());
            model.setInformationHeaderModelArrayList(new ArrayList<>(informationHeaderService.findAll()));
            model.setInformationDetailModelArrayList(finalInformationDetailModelArrayList);
            return model;
        }
    }

    @Override
    public ArrayList<MedicalModel> getMedicalByPatientId(Long patientId) {
        ArrayList<MedicalModel> medicalModelArrayList = new ArrayList<>();
        medicalRepository.findMedicalByPatientId(patientId).forEach(i -> {
            medicalModelArrayList.add(MedicalAdapter.medicalModel(i));
        });
        return medicalModelArrayList;
    }


    @Override
    public MedicalModel add(MedicalModel a) {
        return null;
    }

    @Override
    public List<MedicalModel> findAll() {
        return null;
    }

    @Override
    public MedicalModel findById(Long id) {
        return null;
    }

    @Override
    public MedicalModel edit(MedicalModel a) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}

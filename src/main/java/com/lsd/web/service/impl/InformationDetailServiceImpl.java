package com.lsd.web.service.impl;

import com.lsd.web.exception.ErrorCode;
import com.lsd.web.exception.WebException;
import com.lsd.web.persistance.entity.InformationDetail;
import com.lsd.web.persistance.entity.InformationHeader;
import com.lsd.web.persistance.mapper.InformationDetailAdapter;
import com.lsd.web.persistance.model.InformationDetailModel;
import com.lsd.web.persistance.repository.InformationDetailRepository;
import com.lsd.web.persistance.repository.InformationHeaderRepository;
import com.lsd.web.service.InformationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformationDetailServiceImpl implements InformationDetailService {
    @Autowired
    private InformationDetailRepository informationDetailRepository;

    @Autowired
    private InformationHeaderRepository informationHeaderRepository;

    @Override
    public InformationDetailModel add(InformationDetailModel a) {
        return null;
    }

    @Override
    public List<InformationDetailModel> findAll() {
        List<InformationDetail> list = informationDetailRepository.findAll();
        return list.stream().map(InformationDetailAdapter::informationDetailModel)
                .collect(Collectors.toList());
    }

    @Override
    public InformationDetailModel findById(Long id) {

        InformationDetail de = informationDetailRepository.findById(id).orElse(null);
        if(de == null){
            throw new WebException(ErrorCode.NOT_FOUND);
        }
        InformationDetailModel informationDetailModel = InformationDetailAdapter.informationDetailModel(de);

        return informationDetailModel;
    }

    @Override
    public InformationDetailModel edit(InformationDetailModel a) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public ArrayList<InformationDetailModel> listDetailByHeaderId(Long headerId) {
        Optional<InformationHeader> ih = informationHeaderRepository.findById(headerId);
        ArrayList<InformationDetail> list = informationDetailRepository.findByHeaderId(ih);
        return (ArrayList<InformationDetailModel>) list.stream().map(InformationDetailAdapter::informationDetailModel).collect(Collectors.toList());
    }


    @Override
    public List<InformationDetailModel> listDetailByParentId(Long id) {
        List<InformationDetail> list = informationDetailRepository.findAllParentId(id);
        return list.stream().map(InformationDetailAdapter::informationDetailModel)
                .collect(Collectors.toList());
    }
    @Override
    public ArrayList<InformationDetailModel> getDetailHavHeader() {
        List<InformationDetail> informationDetails = informationDetailRepository.getInformationDetailHeaders();
        ArrayList<InformationDetailModel> informationDetailModels = new ArrayList<>();
        informationDetails.forEach(i -> {
            informationDetailModels.add(InformationDetailAdapter.informationDetailModel(i));
        });
        return informationDetailModels;
    }

}

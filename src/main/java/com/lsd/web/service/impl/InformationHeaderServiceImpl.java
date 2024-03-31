package com.lsd.web.service.impl;

import com.lsd.web.exception.ErrorCode;
import com.lsd.web.exception.ErrorMessageLoader;
import com.lsd.web.exception.WebException;
import com.lsd.web.persistance.entity.InformationHeader;
import com.lsd.web.persistance.mapper.InformationHeaderAdapter;
import com.lsd.web.persistance.model.InformationDetailModel;
import com.lsd.web.persistance.model.InformationHeaderModel;
import com.lsd.web.persistance.repository.InformationHeaderRepository;
import com.lsd.web.service.InformationDetailService;
import com.lsd.web.service.InformationHeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformationHeaderServiceImpl implements InformationHeaderService {
    @Autowired
    private InformationHeaderRepository informationHeaderRepository;

    @Autowired
    InformationDetailService informationDetailService;

    @Override
    public InformationHeaderModel add(InformationHeaderModel a) {
        return null;
    }

    @Override
    public List<InformationHeaderModel> findAll() {
        List<InformationHeader> list = informationHeaderRepository.findAll();
        List<InformationHeaderModel> listH = list.stream().map(InformationHeaderAdapter::informationHeaderModel).collect(Collectors.toList());
        listH.forEach(var -> {
            List<InformationDetailModel> listD = informationDetailService.listDetailByHeaderId(var.getId());
            listD.forEach(pa -> {
                List<InformationDetailModel> listParent = informationDetailService.listDetailByParentId(pa.getId());
                listParent.forEach(ch ->{
                    List<InformationDetailModel> listChild = informationDetailService.listDetailByParentId(ch.getId());
                    listChild.forEach(gra ->{
                        List<InformationDetailModel> listGrandchildren = informationDetailService.listDetailByParentId(gra.getId());
                        listGrandchildren.forEach(gre-> {
                            List<InformationDetailModel> listGreatGrandchildren = informationDetailService.listDetailByParentId(gre.getId());
                            gre.setListChild(listGreatGrandchildren);
                        });
                        gra.setListChild(listGrandchildren);
                    });
                    ch.setListChild(listChild);
                });
                pa.setListChild(listParent);
            });
            var.setListDetail(listD);
        });
        if(listH==null) {
            throw new WebException(ErrorCode.INTERNAL_SERVER, ErrorMessageLoader.getMessage("LSD-01-00"));
        }else {
            return listH;
        }

    }

    @Override
    public InformationHeaderModel findById(Long id) {
        return null;
    }

    @Override
    public InformationHeaderModel edit(InformationHeaderModel a) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}

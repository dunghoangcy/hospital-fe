package com.lsd.web.persistance.mapper;

import com.lsd.web.persistance.entity.InformationDetail;
import com.lsd.web.persistance.model.InformationDetailModel;

public class InformationDetailAdapter {
    private InformationDetail informationDetail;

    public InformationDetailAdapter(InformationDetail informationDetail) {
        this.informationDetail = informationDetail;
    }
    public static InformationDetailModel informationDetailModel(InformationDetail informationDetail) {
        return new InformationDetailModel().builder()
                .id(informationDetail.getId())
                .name(informationDetail.getName())
                .headerId(informationDetail.getHeaderId())
                .parentId(informationDetail.getParentId())
                .status(informationDetail.getStatus())
                .createdAt(informationDetail.getCreatedAt())
                .build();
    }
    public static InformationDetail informationDetail(InformationDetailModel informationDetailModel) {
        return new InformationDetail().builder()
                .id(informationDetailModel.getId())
                .name(informationDetailModel.getName())
                .headerId(informationDetailModel.getHeaderId())
                .parentId(informationDetailModel.getParentId())
                .status(informationDetailModel.getStatus())
                .createdAt(informationDetailModel.getCreatedAt())
                .build();
    }
}

package com.lsd.web.persistance.mapper;

import com.lsd.web.persistance.entity.InformationHeader;
import com.lsd.web.persistance.model.InformationHeaderModel;

public class InformationHeaderAdapter {
    private InformationHeader informationHeader;

    public InformationHeaderAdapter(InformationHeader informationHeader) {
        this.informationHeader = informationHeader;
    }

    public static InformationHeaderModel informationHeaderModel(InformationHeader informationHeader) {
        return new InformationHeaderModel().builder()
                .id(informationHeader.getId())
                .name(informationHeader.getName())
                .status(informationHeader.getStatus())
                .createdAt(informationHeader.getCreatedAt())
                .build();
    }
    public static InformationHeader informationHeader(InformationHeaderModel informationHeaderModel) {
        return new InformationHeader().builder()
                .id(informationHeaderModel.getId())
                .name(informationHeaderModel.getName())
                .status(informationHeaderModel.getStatus())
                .createdAt(informationHeaderModel.getCreatedAt())
                .build();
    }
}

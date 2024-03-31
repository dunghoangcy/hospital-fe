package com.lsd.web.persistance.mapper;

import com.lsd.web.persistance.entity.Image;
import com.lsd.web.persistance.model.ImageModel;

public class ImageMapper {
    public static Image toImage(ImageModel model){
        return Image.builder()
                .id(model.getId())
                .name(model.getName())
                .idMedical(model.getIdMedical())
                .idHeader(model.getIdHeader())
                .status(model.getStatus())
                .createdAt(model.getCreatedAt())
                .build();
    }
    public static ImageModel toImageModel(Image entity){
        return ImageModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .idMedical(entity.getIdMedical())
                .idHeader(entity.getIdHeader())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

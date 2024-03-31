package com.lsd.web.persistance.mapper;


import com.lsd.web.persistance.entity.Statistic;
import com.lsd.web.persistance.model.StatisticModel;

public class StatisticMapper {

    public static Statistic toStatistics(StatisticModel model){
        return Statistic.builder()
                .id(model.getId())
                .idMedical(model.getIdMedical())
                .idDetail(model.getIdDetail())
                .typeNote(model.getTypeNote())
                .value(model.getValue())
                .unit(model.getUnit())
                .status(model.getStatus())
                .createdAt(model.getCreatedAt())
                .build();
    }
    public static StatisticModel toStatisticsModel(Statistic entity){
        return StatisticModel.builder()
                .id(entity.getId())
                .idMedical(entity.getIdMedical())
                .idDetail(entity.getIdDetail())
                .typeNote(entity.getTypeNote())
                .value(entity.getValue())
                .unit(entity.getUnit())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}

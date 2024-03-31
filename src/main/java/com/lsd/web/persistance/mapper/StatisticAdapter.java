package com.lsd.web.persistance.mapper;

import com.lsd.web.persistance.entity.Statistic;
import com.lsd.web.persistance.model.StatisticModel;

public class StatisticAdapter {
    private Statistic statistic;
    public StatisticAdapter (Statistic statistic){this.statistic=statistic;}
    public static StatisticModel statisticModel(Statistic statistic){
        return new StatisticModel().builder()
                .id(statistic.getId())
                .idMedical(statistic.getIdMedical())
                .idDetail(statistic.getIdDetail())
                .typeNote(statistic.getTypeNote())
                .value(statistic.getValue())
                .unit(statistic.getUnit())
                .status(statistic.getStatus())
                .createdAt(statistic.getCreatedAt())
                .build();
    }
    public static Statistic statistic(StatisticModel statisticModel){
        return new Statistic().builder()
                .id(statisticModel.getId())
                .idMedical(statisticModel.getIdMedical())
                .idDetail(statisticModel.getIdDetail())
                .typeNote(statisticModel.getTypeNote())
                .value(statisticModel.getValue())
                .unit(statisticModel.getUnit())
                .status(statisticModel.getStatus())
                .createdAt(statisticModel.getCreatedAt())
                .build();
    }
}

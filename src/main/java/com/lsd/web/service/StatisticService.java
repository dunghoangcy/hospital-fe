package com.lsd.web.service;

import com.lsd.web.persistance.entity.Statistic;
import com.lsd.web.persistance.model.StatisticModel;

import java.util.ArrayList;
import java.util.List;

public interface StatisticService extends BaseService<StatisticModel, Integer>{
    ArrayList<Statistic> listStatisticModelByIdMedical (Integer id);
}

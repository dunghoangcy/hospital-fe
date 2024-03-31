package com.lsd.web.service.impl;

import com.lsd.web.exception.ErrorCode;
import com.lsd.web.exception.WebException;
import com.lsd.web.persistance.entity.Statistic;
import com.lsd.web.persistance.mapper.StatisticAdapter;
import com.lsd.web.persistance.model.StatisticModel;
import com.lsd.web.persistance.repository.StatisticRepository;
import com.lsd.web.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    StatisticRepository statisticRepository;
    //service insert object statistic
    @Override
    public StatisticModel add(StatisticModel a) {
        try {
            Statistic statistic = StatisticAdapter.statistic(a);
            Statistic save = statisticRepository.save(statistic);
            return StatisticAdapter.statisticModel(save);
        }catch (Exception e) {
            throw new WebException(ErrorCode.INTERNAL_SERVER);
        }
    }

    @Override
    public List<StatisticModel> findAll() {
        return null;
    }

    @Override
    public StatisticModel findById(Integer id) {
        return null;
    }

    @Override
    public StatisticModel edit(StatisticModel a) {
        return null;
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    //lấy ra danh sách Statistic theo IdMedical
    @Override
    public ArrayList<Statistic> listStatisticModelByIdMedical(Integer id) {
        return statisticRepository.findStatisticByIdMedical(id);
    }
}

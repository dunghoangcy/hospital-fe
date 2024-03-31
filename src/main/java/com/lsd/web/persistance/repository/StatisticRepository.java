package com.lsd.web.persistance.repository;

import com.lsd.web.persistance.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
    ArrayList<Statistic> findStatisticByIdMedical(Integer id);
}

package com.lsd.web.persistance.repository;


import com.lsd.web.persistance.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistic, Long> {
    ArrayList<Statistic> findStatisticByIdMedical(Long id);
}

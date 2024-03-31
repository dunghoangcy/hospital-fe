package com.lsd.web.persistance.repository;


import com.lsd.web.persistance.entity.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MedicalRepository extends JpaRepository<Medical, Long> {

    ArrayList<Medical> findMedicalByPatientId(Long patientId);
}

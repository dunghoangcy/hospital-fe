package com.lsd.web.persistance.repository;

import com.lsd.web.persistance.entity.Patient;
import com.lsd.web.persistance.model.PatientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT new com.lsd.web.persistance.model.PatientResponse(" +
            " p.id," +
            " p.dateExamination," +
            " p.fullName," +
            " p.yearBirthday," +
            " p.phone," +
            " p.address" +
            ") FROM Patient p " +
            " WHERE (:keySearch = '' OR p.phone = :keySearch OR p.fullName = :keySearch)")
    Page<PatientResponse> findPatientByPhoneAndFullName(Pageable page, @Param("keySearch") String keySearch);

}

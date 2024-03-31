package com.lsd.web.persistance.repository;

import com.lsd.web.persistance.entity.InformationHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationHeaderRepository extends JpaRepository<InformationHeader, Long> {
}

package com.lsd.web.persistance.repository;

import com.lsd.web.persistance.entity.InformationDetail;
import com.lsd.web.persistance.entity.InformationHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface InformationDetailRepository extends JpaRepository<InformationDetail, Long> {
    ArrayList<InformationDetail> findByHeaderId(Optional<InformationHeader> headerId);

    @Query("select c from InformationDetail c where c.parentId = ?1")
    ArrayList<InformationDetail> findAllParentId(Long idSearch);


    @Query("SELECT informationDetail FROM InformationDetail informationDetail WHERE informationDetail.idHeader IS NOT NULL")
    List<InformationDetail> getInformationDetailHeaders();


}

package com.lsd.web.persistance.repository;

import com.lsd.web.persistance.entity.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicailRepository extends JpaRepository<Medical, Long> {
}

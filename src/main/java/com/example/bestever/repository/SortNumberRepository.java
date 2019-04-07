package com.example.bestever.repository;

import com.example.bestever.entity.SortNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SortNumberRepository extends JpaRepository<SortNumber, Long> {
}

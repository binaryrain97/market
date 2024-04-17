package com.example.market.repository;

import com.example.market.model.entity.DailyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DailyRecordRepository extends JpaRepository<DailyRecord, LocalDate> {
    @Query("SELECT r FROM DailyRecord r WHERE r.investor.id = :userId")
    List<DailyRecord> findAllByUserId(String userId);
}

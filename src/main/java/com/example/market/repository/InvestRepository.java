package com.example.market.repository;

import com.example.market.model.entity.Invest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestRepository extends JpaRepository<Invest, Long> {
    @Query("SELECT i FROM Invest i WHERE i.investor.userId = :userId")
    List<Invest> findAllByUserId(String userId);
}

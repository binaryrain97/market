package com.example.market.repository;

import com.example.market.model.entity.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestRepository extends JpaRepository<Invest, Long> {
}

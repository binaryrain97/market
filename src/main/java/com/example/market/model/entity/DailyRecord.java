package com.example.market.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DailyRecord {
    @Id
    private LocalDate date;

    private Long deposit;

    private Long withdrawal;

    private Long currentMoney;

    @ManyToOne
    private Member investor;
}

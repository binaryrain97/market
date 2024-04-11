package com.example.market.model.dto;

import com.example.market.model.entity.DailyRecord;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class DailyRecordDto {
    private LocalDate date;
    private Long deposit;
    private Long withdrawal;
    private Long currentMoney;
    private Long dailyProfit;
    private Long totalProfit;

    public static DailyRecordDto toDto(DailyRecord dailyRecord) {
        return DailyRecordDto.builder()
                .date(dailyRecord.getDate())
                .deposit(dailyRecord.getDeposit())
                .withdrawal(dailyRecord.getWithdrawal())
                .currentMoney(dailyRecord.getCurrentMoney())
                .build();
    }
}

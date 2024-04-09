package com.example.market.model.dto;

import com.example.market.model.entity.Invest;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class InvestDto {
    private LocalDate date;
    private Long money;
    private Double rate;

    public static InvestDto toDto(Invest invest) {
        return InvestDto.builder()
                .date(invest.getDate())
                .money(invest.getMoney())
                .build();
    }
}

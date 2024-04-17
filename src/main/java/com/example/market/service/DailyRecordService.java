package com.example.market.service;

import com.example.market.model.dto.DailyRecordDto;
import com.example.market.model.entity.DailyRecord;
import com.example.market.model.entity.Member;
import com.example.market.repository.DailyRecordRepository;
import com.example.market.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyRecordService {
    private final MemberRepository memberRepository;
    private final DailyRecordRepository dailyRecordRepository;

    public List<DailyRecordDto> getInvestList(String userId) {
        List<DailyRecord> recordList = dailyRecordRepository.findAllByUserId(userId);
        List<DailyRecordDto> recordDtoList = new ArrayList<>();

        Long prevMoney = 0L, totalProfit = 0L;
        for(DailyRecord record : recordList) {
            LocalDate date = record.getDate();
            Long deposit = record.getDeposit();
            Long withdrawal = record.getWithdrawal();
            Long currentMoney = record.getCurrentMoney();
            Long dailyProfit = currentMoney - (prevMoney + deposit - withdrawal);
            totalProfit += dailyProfit;
            prevMoney = currentMoney;
            recordDtoList.add(
                    new DailyRecordDto(date,
                            deposit,
                            withdrawal,
                            currentMoney,
                            dailyProfit,
                            totalProfit));
        }
        return recordDtoList;
    }

    public void createRecord(DailyRecordDto dto, String userId) {
        Optional<Member> _member = this.memberRepository.findById(userId);
        if(_member.isEmpty()) throw new RuntimeException();
        Member member = _member.get();
        DailyRecord record = new DailyRecord(
                dto.getDate(),
                dto.getDeposit() != null ? dto.getDeposit() : 0L,
                dto.getWithdrawal() != null ? dto.getWithdrawal() : 0L,
                dto.getCurrentMoney() != null ? dto.getCurrentMoney() : 0L,
                member
        );
        this.dailyRecordRepository.save(record);
    }
}

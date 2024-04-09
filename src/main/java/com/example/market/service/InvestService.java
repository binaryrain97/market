package com.example.market.service;

import com.example.market.model.dto.InvestDto;
import com.example.market.model.entity.Invest;
import com.example.market.model.entity.Member;
import com.example.market.repository.InvestRepository;
import com.example.market.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvestService {
    private final MemberRepository memberRepository;
    private final InvestRepository investRepository;

    public List<InvestDto> getInvestList(String userId) {
        List<Invest> investList = investRepository.findAllByUserId(userId);
        return investList.stream()
                .map(InvestDto::toDto)
                .toList();
    }

    public void createRecord(InvestDto dto, String userId) {
        Optional<Member> _member = this.memberRepository.findByUserId(userId);
        if(_member.isEmpty()) throw new RuntimeException();
        Member member = _member.get();
        Invest invest = new Invest(dto.getDate(), dto.getMoney(), member);
        this.investRepository.save(invest);
    }
}

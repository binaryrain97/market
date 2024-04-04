package com.example.market.service;

import com.example.market.model.dto.MemberDto;
import com.example.market.model.entity.Member;
import com.example.market.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDto create(String userId, String password) {
        Member member = Member.builder()
                .userId(userId)
                .password(passwordEncoder.encode(password))
                .build();
        Member created = this.memberRepository.save(member);
        return MemberDto.toDto(created);
    }
}

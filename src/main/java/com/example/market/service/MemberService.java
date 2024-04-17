package com.example.market.service;

import com.example.market.model.dto.MemberDto;
import com.example.market.model.entity.Member;
import com.example.market.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberDto create(MemberDto.MemberForm form) {

        Member member = Member.builder()
                .id(form.getId())
                .nickname(form.getNickname())
                .password(passwordEncoder.encode(form.getPassword()))
                .email(form.getEmail())
                .build();
        Member created = this.memberRepository.save(member);
        return MemberDto.toDto(created);
    }

    public MemberDto getMember(String userId) {
        Optional<Member> _member = this.memberRepository.findById(userId);
        if(_member.isEmpty()) throw new RuntimeException("찾을 수 없는 회원입니다.");
        Member member = _member.get();
        return MemberDto.toDto(member);
    }

    public MemberDto findMemberByEmail(String email) {
        Optional<Member> _member = this.memberRepository.findByEmail(email);
        if(_member.isEmpty()) throw new RuntimeException("찾을 수 없는 회원입니다.");
        Member member = _member.get();
        return MemberDto.toDto(member);
    }
}

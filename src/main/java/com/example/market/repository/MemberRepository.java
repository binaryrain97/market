package com.example.market.repository;

import com.example.market.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m WHERE m.id = :id")
    Optional<Member> findById(String id);
    @Query("SELECT m FROM Member m WHERE m.email = :email")
    Optional<Member> findByEmail(String email);
    @Query("SELECT m FROM Member m WHERE m.nickname = :nickname")
    Optional<Member> findByNickname(String nickname);
}

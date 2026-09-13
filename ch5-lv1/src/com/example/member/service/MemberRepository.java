package com.example.member.service;

public interface MemberRepository {
    Member findById(String memberId);
    Member findByEmail(String email);
    boolean existsByEmail(String email);
    void save(Member member);
    void update(Member member);
    void delete(String memberId);
}

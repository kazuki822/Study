package com.example.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(MemberRegistrationService.class);

    private final MemberRepository repository;

    public MemberRegistrationService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member findById(String memberId) {
        logger.debug("会員検索開始: memberId={}", memberId);
        Member member = repository.findById(memberId);
        if (member == null) {
            throw new MemberNotFoundException(memberId);
        }
        return member;
    }

    public Member findByEmail(String email) {
        logger.debug("メール検索開始: email={}", email);
        return repository.findByEmail(email);
    }

    public void register(Member member) {
        logger.info("会員登録開始: name={}", member.getName());
        if (member.getName() == null || member.getName().isBlank()) {
            throw new IllegalArgumentException("名前は必須です");
        }
        if (member.getEmail() == null || !member.getEmail().contains("@")) {
            throw new IllegalArgumentException("メールアドレスの形式が不正です");
        }
        if (repository.existsByEmail(member.getEmail())) {
            throw new IllegalStateException("このメールアドレスはすでに登録されています: " + member.getEmail());
        }
        repository.save(member);
        logger.info("会員登録完了: memberId={}", member.getMemberId());
    }

    public void deactivate(String memberId) {
        logger.info("会員無効化: memberId={}", memberId);
        Member member = repository.findById(memberId);
        if (member == null) {
            throw new MemberNotFoundException(memberId);
        }
        repository.update(member);
    }

    public void delete(String memberId) {
        logger.info("会員削除: memberId={}", memberId);
        if (repository.findById(memberId) == null) {
            throw new MemberNotFoundException(memberId);
        }
        repository.delete(memberId);
    }
}
package com.example.member.service;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String memberId) {
        super("会員が見つかりません: " + memberId);
    }
}
package com.example.point.service;

public interface PointAccountRepository {
    PointAccount findByMemberId(String memberId);
    PointAccount findById(String accountId);
    void save(PointAccount account);
    void update(PointAccount account);
}
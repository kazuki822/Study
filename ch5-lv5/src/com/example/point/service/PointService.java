package com.example.point.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PointService {

    private static final Logger logger =
            LoggerFactory.getLogger(PointService.class);

    private final PointAccountRepository repository;

    public PointService(PointAccountRepository repository) {
        this.repository = repository;
    }

    public PointAccount findByMemberId(String memberId) {
        logger.debug("ポイント口座検索: memberId={}", memberId);

        PointAccount account = repository.findByMemberId(memberId);

        if (account == null) {
            throw new PointException("ポイント口座が見つかりません: " + memberId);
        }

        return account;
    }

    public void add(String memberId, int points) {
        logger.info("ポイント付与: memberId={}, points={}", memberId, points);

        if (points <= 0) {
            throw new PointException("付与ポイントは1以上で指定してください");
        }

        PointAccount account = repository.findByMemberId(memberId);

        if (account == null) {
            throw new PointException("ポイント口座が見つかりません: " + memberId);
        }

        if (!account.isActive()) {
            throw new PointException("無効なポイント口座です: " + memberId);
        }

        account.setCurrentPoints(account.getCurrentPoints() + points);
        account.setLifetimePoints(account.getLifetimePoints() + points);

        updateRank(account);
        repository.update(account);
    }

    public void use(String memberId, int points) {
        logger.info("ポイント利用: memberId={}, points={}", memberId, points);

        if (points <= 0) {
            throw new PointException("利用ポイントは1以上で指定してください");
        }

        PointAccount account = repository.findByMemberId(memberId);

        if (account == null) {
            throw new PointException("ポイント口座が見つかりません: " + memberId);
        }

        if (account.getCurrentPoints() < points) {
            throw new PointException(
                    String.format("ポイント残高不足: 残高=%d, 利用要求=%d",
                            account.getCurrentPoints(), points));
        }

        account.setCurrentPoints(account.getCurrentPoints() - points);
        repository.update(account);
    }

    private void updateRank(PointAccount account) {
        int lifetime = account.getLifetimePoints();

        if (lifetime >= 50000) {
            account.setRank("プラチナ");
        } else if (lifetime >= 10000) {
            account.setRank("ゴールド");
        } else if (lifetime >= 3000) {
            account.setRank("シルバー");
        } else {
            account.setRank("ブロンズ");
        }
    }
}
package com.example.sales;

import java.util.ArrayList;
import java.util.List;

/**
 * 売上レコードのリポジトリクラス。
 */
public class SalesRepository {

    private final List<SalesRecord> records = new ArrayList<>();

    /**
     * 売上レコードを追加する。
     */
    public void add(SalesRecord record) {
        records.add(record);
    }

    /**
     * 全レコードを返す。
     */
    public List<SalesRecord> findAll() {
        return new ArrayList<>(records);
    }

    /**
     * 担当者名で絞り込む。
     */
    public List<SalesRecord> findBySalesRep(String repName) {
        List<SalesRecord> result = new ArrayList<>();

        for (SalesRecord r : records) {
            if (r.getSalesRepName().equals(repName)) {
                result.add(r);
            }
        }

        return result;
    }
}
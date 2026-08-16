package com.example.sales;

import java.util.ArrayList;
import java.util.List;

/**
 * 売上レコードのリポジトリクラス。
 */
public class SalesRepository {

    private final List<SalesRecord> records = new ArrayList<>();

    public void add(SalesRecord record) {
        records.add(record);
    }

    public List<SalesRecord> findAll() {
        return new ArrayList<>(records);
    }
}
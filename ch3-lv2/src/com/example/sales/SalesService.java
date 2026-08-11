package com.example.sales;

import java.util.HashMap;
import java.util.Map;

/**
 * 売上集計サービスクラス。
 */
public class SalesService {

    private final SalesRepository repository;

    /**
     * コンストラクタ。
     * @param repository 売上リポジトリ
     */
    public SalesService(SalesRepository repository) {
        this.repository = repository;
    }

    /**
     * 担当者別売上合計を計算して返す。
     */
    public Map<String, Integer> aggregateByRep() {
        Map<String, Integer> result = new HashMap<>();

        for (SalesRecord r : repository.findAll()) {
            result.put(
                r.getSalesRepName(),
                result.getOrDefault(r.getSalesRepName(), 0)
                    + r.calcAmount()
            );
        }

        return result;
    }

    /**
     * カテゴリ別売上合計を計算して返す。
     */
    public Map<String, Integer> aggregateByCategory() {
        Map<String, Integer> result = new HashMap<>();

        for (SalesRecord r : repository.findAll()) {
            result.put(
                r.getCategory(),
                result.getOrDefault(r.getCategory(), 0)
                    + r.calcAmount()
            );
        }

        return result;
    }

    /**
     * 担当者別集計レポートを印字する。
     */
    public void printRepSummary() {
        Map<String, Integer> totals = aggregateByRep();

        System.out.println("========== 担当者別売上集計 ==========");

        for (Map.Entry<String, Integer> e : totals.entrySet()) {
            System.out.printf(
                "  %-12s  %,10d円%n",
                e.getKey(),
                e.getValue()
            );
        }
    }

    /**
     * カテゴリ別集計レポートを印字する。
     */
    public void printCategorySummary() {
        Map<String, Integer> totals = aggregateByCategory();

        System.out.println("========== カテゴリ別売上集計 ==========");

        for (Map.Entry<String, Integer> e : totals.entrySet()) {
            System.out.printf(
                "  %-16s  %,10d円%n",
                e.getKey(),
                e.getValue()
            );
        }
    }

    /**
     * 売上レコードを登録する。
     * 数量・単価のバリデーションを行う。
     */
    public void register(SalesRecord record) {

        if (record.getQuantity() <= 0) {
            throw new InvalidSalesDataException(
                "quantity",
                record.getQuantity()
            );
        }

        if (record.getUnitPrice() <= 0) {
            throw new InvalidSalesDataException(
                "unitPrice",
                record.getUnitPrice()
            );
        }

        repository.add(record);
    }
}
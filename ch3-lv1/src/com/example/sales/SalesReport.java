package com.example.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 売上レポートを出力するクラス。
 * ※ このクラスにコンパイルエラーが 1 箇所あります。
 */
public class SalesReport {


    private final SalesRepository repository;

    /**
     * コンストラクタ。
     * @param repository 売上レポジトリ
     */
    public SalesReport(SalesRepository repository) {
        this.repository = repository;
    }

    /**
     * 日次売上サマリーを標準出力に印字する。
     */
    public void printDailySummary() {
        List<SalesRecord> all = repository.findAll();

        System.out.println("========== 日次売上サマリー ==========");

        Map<String, Integer> repTotals = new HashMap<>();
        int grandTotal = 0;

        for (SalesRecord r : all) {
            int amount = r.calcAmount();
            grandTotal += amount;
            repTotals.put(r.getSalesRepName(),
                repTotals.getOrDefault(r.getSalesRepName(), 0) + amount);
        }

        System.out.printf("%-6s  %-18s  %-10s  %10s  %6s%n",
            "売上ID", "商品ID", "担当者", "金額（円）", "数量");
        System.out.println("--------------------------------------------------------------");

        for (SalesRecord r : all) {
            System.out.printf("%-6s  %-18s  %-10s  %,10d  %6d%n",
                r.getSalesId(),
                r.getProductId(),
                r.getSalesRepName(),
                r.calcAmount(),
                r.getQuantity()
            );
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("【担当者別集計】");
        for (Map.Entry<String, Integer> entry : repTotals.entrySet()) {
            System.out.printf("  %-10s  %,10d円%n", entry.getKey(), entry.getValue());
        }

        System.out.printf("%n合計売上：%,d円%n", grandTotal);
    }
}

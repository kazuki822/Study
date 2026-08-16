package com.example.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 売上集計サービスクラス。
 * コンパイルエラーをすべて修正した後に実行すると、実行時例外が1箇所発生します。
 */
public class SalesService {

    private final SalesRepository repository;

    /** 担当者ごとの月次目標金額（円） */
    private final Map<String, Integer> targets = new HashMap<>();

    public SalesService(SalesRepository repository) {
        this.repository = repository;
    }

    /**
     * 月次目標を設定する。
     */
    public void setTarget(String repName, int target) {
        targets.put(repName, target);
    }

    /**
     * 売上レコードを登録する。
     */
    public void register(SalesRecord record) {
        if (record.getQuantity() <= 0) {
            throw new InvalidSalesDataException(
                "quantity",
                record.getQuantity()
            );
        }

        repository.add(record);
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
     * 商品別売上集計を返す。
     */
    public Map<String, Integer> aggregateByProduct() {

        Map<String, Integer> result = new HashMap<>();

        for (SalesRecord r : repository.findAll()) {

            result.put(
                r.getProductId(),
                result.getOrDefault(r.getProductId(), 0)
                    + r.calcAmount()
            );
        }

        return result;
    }

    /**
     * 商品別売上数量集計を返す。
     */
    public Map<String, Integer> aggregateQuantityByProduct() {

        Map<String, Integer> result = new HashMap<>();

        for (SalesRecord r : repository.findAll()) {

            result.put(
                r.getProductId(),
                result.getOrDefault(r.getProductId(), 0)
                    + r.getQuantity()
            );
        }

        return result;
    }

    /**
     * 商品カテゴリ取得マップを返す。
     */
    private Map<String, String> buildProductCategoryMap() {

        Map<String, String> map = new HashMap<>();

        for (SalesRecord r : repository.findAll()) {
            map.put(
                r.getProductId(),
                r.getCategory()
            );
        }

        return map;
    }

    /**
     * 商品別売上ランキングを印字する。
     */
    public void printProductRanking() {

        Map<String, Integer> amounts =
            aggregateByProduct();

        Map<String, Integer> quantities =
            aggregateQuantityByProduct();

        Map<String, String> categoryMap =
            buildProductCategoryMap();

        List<Map.Entry<String, Integer>> sortedAmounts =
            new java.util.ArrayList<>(amounts.entrySet());

        sortedAmounts.sort(
            (a, b) -> b.getValue() - a.getValue()
        );

        System.out.println(
            "========== 商品別売上ランキング =========="
        );

        System.out.printf(
            "%-4s  %-8s  %-10s  %12s  %6s%n",
            "順位",
            "商品ID",
            "カテゴリ",
            "売上金額",
            "数量"
        );

        int rank = 1;

        for (Map.Entry<String, Integer> entry : sortedAmounts) {

            String productId = entry.getKey();

            System.out.printf(
            	    "%-4s  %-8s  %-10s  %,12d円  %6d個%n",
            	    rank + "位",
            	    productId,
            	    categoryMap.getOrDefault(productId, "不明"),
            	    entry.getValue(),
            	    quantities.getOrDefault(productId, 0)
            	);

            	rank++;
        }
    }

    /**
     * 担当者別達成率レポートを印字する。
     */
    public void printRepAchievementReport() {

        Map<String, Integer> actuals =
            aggregateByRep();

        System.out.println(
            "\n========== 担当者別達成率 =========="
        );

        System.out.printf(
            "%-10s  %12s  %12s  %6s%n",
            "担当者",
            "実績（円）",
            "目標（円）",
            "達成率"
        );

        for (Map.Entry<String, Integer> e : actuals.entrySet()) {

            String repName = e.getKey();
            int actual = e.getValue();

            Integer target = targets.get(repName);

            if (target == null) {

                System.out.printf(
                    "%-10s  %,12d  %s%n",
                    repName,
                    actual,
                    "目標未設定"
                );

            } else {

                double rate = (double) actual / target * 100.0;

                System.out.printf(
                    "%-10s  %,12d  %,12d  %5.1f%%%n",
                    repName,
                    actual,
                    target,
                    rate
                );
            }
        }
    }
}
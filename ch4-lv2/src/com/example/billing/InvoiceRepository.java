package com.example.billing;

import java.util.HashMap;
import java.util.Map;

/**
 * 請求書のリポジトリクラス。
 */
public class InvoiceRepository {

    private final Map<String, Invoice> invoices = new HashMap<>();

    public InvoiceRepository(javax.sql.DataSource dataSource) {
        // 今回はデータベースを使用しない
    }

    /**
     * 請求書を登録する。
     * @param invoice 登録する請求書
     */
    public void insert(Invoice invoice) {
        invoices.put(invoice.getInvoiceId(), invoice);
    }

    /**
     * 請求書IDで検索する。
     * @param invoiceId 検索する請求書ID
     * @return 見つかったInvoice、存在しない場合はnull
     */
    public Invoice findById(String invoiceId) {
        return invoices.get(invoiceId);
    }

    /**
     * ステータスを更新する。
     * @param invoiceId 対象の請求書ID
     * @param status 新しいステータス
     */
    public void updateStatus(String invoiceId, String status) {
        Invoice invoice = invoices.get(invoiceId);

        if (invoice != null) {
            invoice.setStatus(status);
        }
    }
}
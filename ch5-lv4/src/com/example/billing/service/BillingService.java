package com.example.billing.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BillingService {

    private static final Logger logger =
            LoggerFactory.getLogger(BillingService.class);

    private final InvoiceRepository repository;

    public BillingService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public Invoice findById(String invoiceId) {
        logger.debug("請求書検索: invoiceId={}", invoiceId);
        return repository.findById(invoiceId);
    }

    /** 税込金額を返す。税率は整数（例: 10 → 10%）。割引後に税を適用する */
    public int calcTotalWithTax(String invoiceId) {
        Invoice invoice = repository.findById(invoiceId);

        if (invoice == null) {
            throw new BillingException("請求書が見つかりません: " + invoiceId);
        }

        int afterDiscount = invoice.getSubtotal() - invoice.getDiscountAmount();

        return (int) Math.round(
                afterDiscount * (1 + invoice.getTaxRate() / 100.0));
    }

    public void markAsPaid(String invoiceId) {
        logger.info("入金処理: invoiceId={}", invoiceId);

        Invoice invoice = repository.findById(invoiceId);

        if (invoice == null) {
            throw new BillingException("請求書が見つかりません: " + invoiceId);
        }

        if ("入金済".equals(invoice.getStatus())) {
            throw new BillingException("すでに入金済みの請求書です: " + invoiceId);
        }

        invoice.setStatus("入金済");
        repository.update(invoice);
    }

    public List<Invoice> findUnpaid() {
        logger.info("未払い請求書取得");
        return repository.findUnpaid();
    }

    public void issue(Invoice invoice) {
        logger.info("請求書発行: invoiceId={}", invoice.getInvoiceId());

        if (invoice.getSubtotal() <= 0) {
            throw new BillingException("請求金額は1円以上である必要があります");
        }

        if (invoice.getTaxRate() < 0 || invoice.getTaxRate() > 100) {
            throw new BillingException("税率は0〜100の範囲で指定してください");
        }

        repository.save(invoice);
    }
}
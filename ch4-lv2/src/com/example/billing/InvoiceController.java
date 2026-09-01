package com.example.billing;

/**
 * 請求書発行のコントローラクラス（Servlet ベース想定）。
 */
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    /**
     * 請求書発行リクエストを処理する。
     * @param invoiceId 請求書 ID
     * @param client    取引先
     * @param invoice   発行する請求書
     */
    public void handleIssue(
            String invoiceId,
            Client client,
            Invoice invoice) {

        service.issue(invoice);
        service.printInvoice(invoice, client);
    }

    /**
     * 請求書承認リクエストを処理する。
     * @param invoiceId 承認する請求書 ID
     */
    public void handleApprove(String invoiceId) {

        Invoice approvedInvoice = service.approve(invoiceId);
    }
}
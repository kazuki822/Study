package com.example.billing.service;

import java.util.List;

public interface InvoiceRepository {
    Invoice findById(String invoiceId);
    List<Invoice> findByCustomerId(String customerId);
    List<Invoice> findUnpaid();
    void save(Invoice invoice);
    void update(Invoice invoice);
}
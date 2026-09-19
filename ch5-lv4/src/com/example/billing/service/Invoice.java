package com.example.billing.service;

public class Invoice {

    private String invoiceId;
    private String customerId;
    private String customerName;
    private int subtotal;
    private int taxRate;
    private int discountAmount;
    private String issueDate;
    private String dueDate;
    private String status;

    public Invoice(String invoiceId, String customerId, String customerName,
                   int subtotal, int taxRate, int discountAmount,
                   String issueDate, String dueDate, String status) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.subtotal = subtotal;
        this.taxRate = taxRate;
        this.discountAmount = discountAmount;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getInvoiceId()    { return invoiceId; }
    public String getCustomerId()   { return customerId; }
    public String getCustomerName() { return customerName; }
    public int getSubtotal()        { return subtotal; }
    public int getTaxRate()         { return taxRate; }
    public int getDiscountAmount()  { return discountAmount; }
    public String getIssueDate()    { return issueDate; }
    public String getDueDate()      { return dueDate; }
    public String getStatus()       { return status; }
    public void setStatus(String s) { this.status = s; }
}
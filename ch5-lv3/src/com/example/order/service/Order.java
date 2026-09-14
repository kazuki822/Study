package com.example.order.service;

import java.util.List;

public class Order {

    private String orderId;
    private String customerId;
    private String customerName;
    private List<OrderItem> items;
    private String status;
    private String orderDate;
    private String shippingAddress;
    private String note;

    public Order(String orderId, String customerId, String customerName,
                 List<OrderItem> items, String status, String orderDate,
                 String shippingAddress, String note) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.items = items;
        this.status = status;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.note = note;
    }

    public String getOrderId()        { return orderId; }
    public String getCustomerId()     { return customerId; }
    public String getCustomerName()   { return customerName; }
    public List<OrderItem> getItems() { return items; }
    public String getStatus()         { return status; }
    public String getOrderDate()      { return orderDate; }
    public String getShippingAddress(){ return shippingAddress; }
    public String getNote()           { return note; }
    public void setStatus(String s)   { this.status = s; }

    public int getTotalAmount() {
        return items.stream().mapToInt(OrderItem::getSubtotal).sum();
    }
}
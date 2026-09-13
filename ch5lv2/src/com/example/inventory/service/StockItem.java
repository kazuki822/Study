package com.example.inventory.service;

public class StockItem {

    private String itemCode;
    private String itemName;
    private String category;
    private int quantity;
    private int reorderPoint;
    private int unitCost;
    private String warehouseLocation;
    private String lastUpdatedAt;

    public StockItem(String itemCode, String itemName, String category, int quantity,
                     int reorderPoint, int unitCost, String warehouseLocation, String lastUpdatedAt) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.reorderPoint = reorderPoint;
        this.unitCost = unitCost;
        this.warehouseLocation = warehouseLocation;
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getItemCode()         { return itemCode; }
    public String getItemName()         { return itemName; }
    public String getCategory()         { return category; }
    public int getQuantity()            { return quantity; }
    public int getReorderPoint()        { return reorderPoint; }
    public int getUnitCost()            { return unitCost; }
    public String getWarehouseLocation(){ return warehouseLocation; }
    public String getLastUpdatedAt()    { return lastUpdatedAt; }
    public void setQuantity(int q)      { this.quantity = q; }
}

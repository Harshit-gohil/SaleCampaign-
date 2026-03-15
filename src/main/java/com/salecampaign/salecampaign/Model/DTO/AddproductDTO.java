package com.salecampaign.salecampaign.Model.DTO;

import java.math.BigDecimal;

public class AddproductDTO {
    private String Title;

    private BigDecimal MRP;

    private BigDecimal basePrice;

    private BigDecimal currentPrice;

    private Integer inventoryCount;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public BigDecimal getMRP() {
        return MRP;
    }

    public void setMRP(BigDecimal MRP) {
        this.MRP = MRP;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}

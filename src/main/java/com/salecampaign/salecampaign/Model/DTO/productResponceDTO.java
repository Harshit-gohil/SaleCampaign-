package com.salecampaign.salecampaign.Model.DTO;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class productResponceDTO {
    private Long productId;

    private String Title;

    private BigDecimal MRP;

    private BigDecimal basePrice;

    private BigDecimal currentPrice;

    private BigDecimal discount;

    private Integer inventoryCount;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}

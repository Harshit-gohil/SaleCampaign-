package com.salecampaign.salecampaign.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceHistoryId;

    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private products products;

    private BigDecimal oldPrices;

    private BigDecimal newPrice;

    private LocalDateTime changedAt;

    public Long getPriceHistoryId() {
        return priceHistoryId;
    }

    public void setPriceHistoryId(Long priceHistoryId) {
        this.priceHistoryId = priceHistoryId;
    }

    public products getProducts() {
        return products;
    }

    public void setProducts(products products) {
        this.products = products;
    }

    public BigDecimal getOldPrices() {
        return oldPrices;
    }

    public void setOldPrices(BigDecimal oldPrices) {
        this.oldPrices = oldPrices;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}

package com.salecampaign.salecampaign.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String Title;

    private BigDecimal MRP;

    private BigDecimal basePrice;

    private BigDecimal currentPrice;

    private Integer inventoryCount;

    @JsonIgnore
    @OneToMany(mappedBy = "products",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<campaignProduct> campaignProduct;

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public List<campaignProduct> getCampaignProduct() {
        return campaignProduct;
    }

    public void setCampaignProduct(List<campaignProduct> campaignProduct) {
        this.campaignProduct = campaignProduct;
    }

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

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}

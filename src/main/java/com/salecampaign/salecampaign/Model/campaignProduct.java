package com.salecampaign.salecampaign.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class  campaignProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignProductId;

    @Column(nullable = false)
    private BigDecimal discount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "campaignid",nullable = false)
    private campaign campaign;

    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private products products;

    public Long getCampaignProductId() {
        return campaignProductId;
    }

    public void setCampaignProductId(Long campaignProductId) {
        this.campaignProductId = campaignProductId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(campaign campaign) {
        this.campaign = campaign;
    }

    public products getProducts() {
        return products;
    }

    public void setProducts(products products) {
        this.products = products;
    }
}


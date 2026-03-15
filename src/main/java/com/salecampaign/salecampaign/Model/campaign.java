package com.salecampaign.salecampaign.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<campaignProduct> campaignProduct;

    private boolean priceApplied = false;
    private boolean priceReverted = false;

    public boolean isPriceApplied() {
        return priceApplied;
    }

    public void setPriceApplied(boolean priceApplied) {
        this.priceApplied = priceApplied;
    }

    public boolean isPriceReverted() {
        return priceReverted;
    }

    public void setPriceReverted(boolean priceReverted) {
        this.priceReverted = priceReverted;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<campaignProduct> getCampaignProduct() {
        return campaignProduct;
    }

    public void setCampaignProduct(List<campaignProduct> campaignProduct) {
        this.campaignProduct = campaignProduct;
    }
}

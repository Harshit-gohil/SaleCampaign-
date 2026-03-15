package com.salecampaign.salecampaign.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salecampaign.salecampaign.Model.campaignProduct;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

public class campaignGetDTO {

    private Long campaignId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private List<campaignProduct> campaignProduct;

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

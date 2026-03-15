package com.salecampaign.salecampaign.Model.DTO;

import com.salecampaign.salecampaign.Model.campaignProduct;

import java.time.LocalDate;
import java.util.List;

public class campaignRequestDTO {
    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<DiscountRequestDTO> Products;

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

    public List<DiscountRequestDTO> getProducts() {
        return Products;
    }

    public void setProducts(List<DiscountRequestDTO> products) {
        Products = products;
    }
}

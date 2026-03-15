package com.salecampaign.salecampaign.Model.DTO;

import com.salecampaign.salecampaign.Model.products;

import java.time.LocalDate;
import java.util.List;

public class DeleteCampaignDTO {

    private String Message;

    private String title;

    private LocalDate startDate;

    private LocalDate endDate;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
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

}

package com.salecampaign.salecampaign.Model.DTO;

public class campaignCreateResponceDTO {
    private String message;
    private Long campId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCampId() {
        return campId;
    }

    public void setCampId(Long campId) {
        this.campId = campId;
    }
}

package com.salecampaign.salecampaign.Model.DTO;

import java.math.BigDecimal;


public class DiscountRequestDTO {
        private Long productId;
        private BigDecimal discount;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }


}

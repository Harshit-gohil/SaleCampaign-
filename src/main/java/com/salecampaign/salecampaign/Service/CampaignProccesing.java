package com.salecampaign.salecampaign.Service;

import com.salecampaign.salecampaign.Model.PriceHistory;
import com.salecampaign.salecampaign.Model.campaign;
import com.salecampaign.salecampaign.Model.campaignProduct;
import com.salecampaign.salecampaign.Model.products;
import com.salecampaign.salecampaign.Repository.pricehistoryRepository;
import com.salecampaign.salecampaign.Repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CampaignProccesing {
    @Autowired
    private productRepository productRepository;

    @Autowired
    private pricehistoryRepository pricehistoryRepository;

    @Async("campaignExecutor")
    @Transactional
    public void applyCampaign(campaign campaign) {

        Long campaignId = campaign.getCampaignId();

        pricehistoryRepository.insertPriceHistoryBulk(campaignId);
        productRepository.applyCampaignBulk(campaignId);
    }

    @Async("campaignExecutor")
    @Transactional
    public void revertCampaign(campaign campaign) {

        Long campaignId = campaign.getCampaignId();
        pricehistoryRepository.insertRevertPriceHistoryBulk(campaignId);
        productRepository.revertCampaignBulk(campaignId);
        }
    }


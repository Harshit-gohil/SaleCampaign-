package com.salecampaign.salecampaign.scheduler;

import com.salecampaign.salecampaign.Repository.campaignProductRepository;
import com.salecampaign.salecampaign.Model.PriceHistory;
import com.salecampaign.salecampaign.Model.campaign;
import com.salecampaign.salecampaign.Model.campaignProduct;
import com.salecampaign.salecampaign.Model.products;
import com.salecampaign.salecampaign.Repository.campaignRepository;
import com.salecampaign.salecampaign.Repository.pricehistoryRepository;
import com.salecampaign.salecampaign.Repository.productRepository;
import com.salecampaign.salecampaign.Service.CampaignProccesing;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Component
public class campaignScheduler {

    @Autowired
    private campaignRepository campaignRepo;

    @Autowired
    private CampaignProccesing campaignProcessingService;

    @Scheduled(fixedRate = 60000)
    public void campaign() {

        LocalDate today = LocalDate.now();

        List<campaign> campaignToStart =
                campaignRepo.findByStartDateLessThanEqualAndPriceAppliedFalse(today);

        for (campaign campaign : campaignToStart) {
            campaignProcessingService.applyCampaign(campaign);
            campaign.setPriceApplied(true);
            campaignRepo.save(campaign);
        }

        List<campaign> campaignToEnd =
                campaignRepo.findByEndDateLessThanEqualAndPriceRevertedFalse(today);

        for (campaign campaign : campaignToEnd) {
            campaignProcessingService.revertCampaign(campaign);
            campaign.setPriceReverted(true);
            campaignRepo.save(campaign);
        }
    }
}
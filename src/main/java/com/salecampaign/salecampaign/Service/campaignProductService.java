package com.salecampaign.salecampaign.Service;

import com.salecampaign.salecampaign.Model.campaignProduct;
import com.salecampaign.salecampaign.Model.products;
import com.salecampaign.salecampaign.Repository.campaignProductRepository;
import com.salecampaign.salecampaign.Repository.campaignRepository;
import com.salecampaign.salecampaign.Repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class campaignProductService {
    @Autowired
    private productRepository productRepo;
    @Autowired
    private campaignRepository campaignRepo;
    @Autowired
    private campaignProductRepository campaignProductRepo;

    public campaignProductService(productRepository productRepo, campaignRepository campaignRepo, campaignProductRepository campaignProductRepo) {
        this.productRepo = productRepo;
        this.campaignRepo = campaignRepo;
        this.campaignProductRepo = campaignProductRepo;
    }

    public Page<campaignProduct> getCampaignProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return campaignProductRepo.findAll(pageable);
    }
}

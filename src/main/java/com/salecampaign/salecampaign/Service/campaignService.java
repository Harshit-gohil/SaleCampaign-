package com.salecampaign.salecampaign.Service;

import com.salecampaign.salecampaign.Model.DTO.*;
import com.salecampaign.salecampaign.Model.campaign;
import com.salecampaign.salecampaign.Model.campaignProduct;
import com.salecampaign.salecampaign.Model.products;
import com.salecampaign.salecampaign.Repository.campaignProductRepository;
import com.salecampaign.salecampaign.Repository.campaignRepository;
import com.salecampaign.salecampaign.Repository.productRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@Qualifier("campaignExecutor")
public class campaignService {
    @Autowired
    private productRepository productRepo;
    private campaignRepository campaignRepo;
    private campaignProductRepository campaignProductRepo;

    public campaignService(productRepository productRepo, campaignRepository campaignRepo, campaignProductRepository campaignProductRepo) {
        this.productRepo = productRepo;
        this.campaignRepo = campaignRepo;
        this.campaignProductRepo = campaignProductRepo;
    }

    @Transactional
    public campaignCreateResponceDTO createCampaign(campaignRequestDTO campaignRequest) {

        if (campaignRequest.getStartDate().isAfter(campaignRequest.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        List<Long> productIds = new ArrayList<>();
        for (DiscountRequestDTO dto : campaignRequest.getProducts()) {
            productIds.add(dto.getProductId());
        }

        Optional<Integer> overlap = campaignProductRepo.existsOverlappingCampaign(
                productIds,
                campaignRequest.getStartDate(),
                campaignRequest.getEndDate()
        );

        if (overlap.isPresent()) {
            System.out.println("Overlap found!");
            throw new IllegalArgumentException("Overlapping campaign exists for one or more products");
        }

        campaign campaign = new campaign();
        campaign.setTitle(campaignRequest.getTitle());
        campaign.setStartDate(campaignRequest.getStartDate());
        campaign.setEndDate(campaignRequest.getEndDate());

        List<campaignProduct> campaignProducts = new ArrayList<>();

        List<Long> productId = campaignRequest.getProducts()
                .stream()
                .map(DiscountRequestDTO::getProductId)
                .toList();

        List<products> productsList = productRepo.findAllById(productId);

        Map<Long, products> productMap = productsList.stream()
                .collect(Collectors.toMap(products::getProductId, p -> p));

        for (DiscountRequestDTO dto : campaignRequest.getProducts()) {

            products product = productMap.get(dto.getProductId());

            if (product == null) {
                throw new IllegalArgumentException("Product not found");
            }

            campaignProduct cp = new campaignProduct();
            cp.setCampaign(campaign);
            cp.setProducts(product);
            cp.setDiscount(dto.getDiscount());

            campaignProducts.add(cp);
        }

        campaign.setCampaignProduct(campaignProducts);

        campaign savedCampaign = campaignRepo.save(campaign);

        campaignCreateResponceDTO responceDTO=new campaignCreateResponceDTO();
        responceDTO.setCampId(campaign.getCampaignId());
        responceDTO.setMessage("Campagin Created Succesfully");
        return responceDTO;
    }


    public campaignGetDTO getCampaign(Long cId){

        campaign campaign=campaignRepo.findById(cId).orElseThrow(() -> new IllegalArgumentException("Campaign not found"));

        campaignGetDTO campaignGetDTO=new campaignGetDTO();
        campaignGetDTO.setCampaignId(cId);
        campaignGetDTO.setTitle(campaign.getTitle());
        campaignGetDTO.setStartDate(campaign.getStartDate());
        campaignGetDTO.setEndDate(campaign.getEndDate());
        List<campaignProduct> products= campaign.getCampaignProduct();
        campaignGetDTO.setCampaignProduct(products);

        return campaignGetDTO;
    }
    public DeleteCampaignDTO deleteCampaign(Long campaignId){
        campaign campaign=campaignRepo.findById(campaignId)
                .orElseThrow(() -> new IllegalArgumentException("Campaign not found"));

        campaignRepo.delete(campaign);
        DeleteCampaignDTO responce=new DeleteCampaignDTO();
        responce.setMessage("Campaign Deleted Succesfully ");
        responce.setTitle(campaign.getTitle());
        responce.setStartDate(campaign.getStartDate());
        responce.setEndDate(campaign.getEndDate());

        return responce;
    }
    }


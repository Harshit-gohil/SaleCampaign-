package com.salecampaign.salecampaign.Service;

import com.salecampaign.salecampaign.Model.DTO.AddproductDTO;
import com.salecampaign.salecampaign.Model.products;
import com.salecampaign.salecampaign.Repository.campaignProductRepository;
import com.salecampaign.salecampaign.Repository.campaignRepository;
import com.salecampaign.salecampaign.Repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class productService {
    @Autowired
    private productRepository productRepo;
    @Autowired
    private campaignRepository campaignRepo;
    @Autowired
    private campaignProductRepository campaignProductRepo;

    public productService(productRepository productRepo, campaignRepository campaignRepo, campaignProductRepository campaignProductRepo) {
        this.productRepo = productRepo;
        this.campaignRepo = campaignRepo;
        this.campaignProductRepo = campaignProductRepo;
    }

    public AddproductDTO addProduct(AddproductDTO request){
        products product=new products();

        product.setTitle(request.getTitle());
        product.setMRP(request.getMRP());
        product.setBasePrice(request.getBasePrice());
        product.setCurrentPrice(request.getCurrentPrice());
        product.setInventoryCount(request.getInventoryCount());

        productRepo.save(product);

        return request;
    }
}

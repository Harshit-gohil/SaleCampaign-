package com.salecampaign.salecampaign.Controller;

import com.salecampaign.salecampaign.Model.campaignProduct;
import com.salecampaign.salecampaign.Service.campaignProductService;
import com.salecampaign.salecampaign.Service.campaignService;
import com.salecampaign.salecampaign.Service.productService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/saleCampaign")
public class campaignProductController {

    @Autowired
    private campaignService campaignService;
    @Autowired
    private productService productService;
    @Autowired
    private campaignProductService campaignProductService;


    public campaignProductController(campaignService campaignService, productService productService,campaignProductService campaignProductService) {
        this.campaignService = campaignService;
        this.productService = productService;
        this.campaignProductService = campaignProductService;
    }

    @GetMapping("/campaign-products")
    public ResponseEntity<Map<String, Object>> getCampaignProducts(
            @RequestParam int page,
            @RequestParam int pageSize) {

        Page<campaignProduct> campaignProductPage =
                campaignProductService.getCampaignProducts(page, pageSize);

        Map<String, Object> response = new HashMap<>();

        response.put("data", campaignProductPage.getContent());
        response.put("page", page);
        response.put("pageSize", pageSize);
        response.put("totalPages", campaignProductPage.getTotalPages());
        response.put("totalElements", campaignProductPage.getTotalElements());

        
        return ResponseEntity.ok(response);
    }
}

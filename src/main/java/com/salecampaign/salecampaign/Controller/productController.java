package com.salecampaign.salecampaign.Controller;

import com.salecampaign.salecampaign.Model.DTO.AddproductDTO;
import com.salecampaign.salecampaign.Service.campaignService;
import com.salecampaign.salecampaign.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saleCampaign")
public class productController {

    @Autowired
    private campaignService campaignService;
    @Autowired
    private productService productService;

    public productController(campaignService campaignService, productService productService) {
        this.campaignService = campaignService;
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<AddproductDTO> addProduct(@RequestBody AddproductDTO request){
        AddproductDTO responce=productService.addProduct(request);
        return ResponseEntity.ok(responce);
    }
}

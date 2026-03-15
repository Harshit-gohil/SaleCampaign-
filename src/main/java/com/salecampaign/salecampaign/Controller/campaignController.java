package com.salecampaign.salecampaign.Controller;

import com.salecampaign.salecampaign.Model.DTO.DeleteCampaignDTO;
import com.salecampaign.salecampaign.Model.DTO.campaignCreateResponceDTO;
import com.salecampaign.salecampaign.Model.DTO.campaignGetDTO;
import com.salecampaign.salecampaign.Model.DTO.campaignRequestDTO;
import com.salecampaign.salecampaign.Service.campaignService;
import com.salecampaign.salecampaign.Service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saleCampaign")
public class campaignController {

    @Autowired
    private campaignService campaignService;
    @Autowired
    private productService productService;

    public campaignController(campaignService campaignService, productService productService) {
        this.campaignService = campaignService;
        this.productService = productService;
    }

    @PostMapping("/campaigns")
    public ResponseEntity<campaignCreateResponceDTO> createCampaign(@RequestBody campaignRequestDTO requestDTO) {

        campaignCreateResponceDTO responceDTO =
                campaignService.createCampaign(requestDTO);

        return ResponseEntity.ok(responceDTO);
    }

    @GetMapping("/getCampaign/{cId}")
    public ResponseEntity<campaignGetDTO> getCampaign(@PathVariable Long cId){
        campaignGetDTO Response=campaignService.getCampaign(cId);
        return ResponseEntity.ok(Response);
    }


    @DeleteMapping("/deleteCampaign/{campaignId}")
    public ResponseEntity<DeleteCampaignDTO> deleteCampaign(@PathVariable Long campaignId){

        DeleteCampaignDTO responce =
                campaignService.deleteCampaign(campaignId);

        return ResponseEntity.ok(responce);
    }
}

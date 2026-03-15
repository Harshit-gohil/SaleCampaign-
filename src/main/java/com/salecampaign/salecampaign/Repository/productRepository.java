package com.salecampaign.salecampaign.Repository;

import com.salecampaign.salecampaign.Model.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface productRepository extends JpaRepository<products,Long> {
    @Modifying
    @Transactional
    @Query(value = """
    UPDATE products p
    JOIN campaign_product cp ON p.id = cp.product_id
    SET p.current_price = p.base_price - (p.base_price * cp.discount / 100)
    WHERE cp.campaign_id = :campaignId
""", nativeQuery = true)
    void applyCampaignBulk(@Param("campaignId") Long campaignId);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE products p
    JOIN campaign_product cp ON p.id = cp.product_id
    SET p.current_price = p.base_price
    WHERE cp.campaign_id = :campaignId
""", nativeQuery = true)
    void revertCampaignBulk(@Param("campaignId") Long campaignId);


}

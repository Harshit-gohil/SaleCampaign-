package com.salecampaign.salecampaign.Repository;

import com.salecampaign.salecampaign.Model.PriceHistory;
import com.salecampaign.salecampaign.Model.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface pricehistoryRepository extends JpaRepository<PriceHistory,Long> {
    @Modifying
    @Transactional
    @Query(value = """
    INSERT INTO price_history (product_id, old_prices, new_price, changed_at)
    SELECT 
        p.id,
        p.current_price,
        p.base_price - (p.base_price * cp.discount / 100),
        NOW()
    FROM products p
    JOIN campaign_product cp ON p.id = cp.product_id
    WHERE cp.campaign_id = :campaignId
""", nativeQuery = true)
    void insertPriceHistoryBulk(@Param("campaignId") Long campaignId);


    @Modifying
    @Transactional
    @Query(value = """
    INSERT INTO price_history (product_id, old_prices, new_price, changed_at)
    SELECT 
        p.id,
        p.current_price,
        p.base_price,
        NOW()
    FROM products p
    JOIN campaign_product cp ON p.id = cp.product_id
    WHERE cp.campaign_id = :campaignId
""", nativeQuery = true)
    void insertRevertPriceHistoryBulk(@Param("campaignId") Long campaignId);

}

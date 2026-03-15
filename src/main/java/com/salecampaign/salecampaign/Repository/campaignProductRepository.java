package com.salecampaign.salecampaign.Repository;

import com.salecampaign.salecampaign.Model.campaign;
import com.salecampaign.salecampaign.Model.campaignProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface campaignProductRepository extends JpaRepository<campaignProduct,Long> {

    @Query(
            value = """
                    SELECT 1 
                    FROM campaign_product cp
                    JOIN campaign c ON cp.campaignid=c.campaign_id
                    WHERE cp.product_id IN (:productIds)
                    AND :newStart <= c.end_date
                    AND :newEnd >=c.start_date
                    LIMIT 1
                    """,nativeQuery = true
    )
    Optional<Integer> existsOverlappingCampaign(
            @Param("productIds")List<Long> productIds,
            @Param("newStart") LocalDate newStart,
            @Param("newEnd") LocalDate newEnd
            );


}

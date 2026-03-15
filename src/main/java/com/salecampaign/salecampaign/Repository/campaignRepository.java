package com.salecampaign.salecampaign.Repository;

import com.salecampaign.salecampaign.Model.campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface campaignRepository extends JpaRepository<campaign,Long> {

    List<campaign>  findByStartDateLessThanEqualAndPriceAppliedFalse(LocalDate date);

    List<campaign> findByEndDateLessThanEqualAndPriceRevertedFalse(LocalDate date);
}

package com.viettel.managebe.repository;

import com.viettel.managebe.model.RecruitmentOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface RecruitmentOrganizationRepository extends JpaRepository<RecruitmentOrganization, Long> {

    @Override
    List<RecruitmentOrganization> findAll();

    @Query("SELECT o.id, o.name, r.effective_start_date, r.effective_end_date, r.scope, r.officeAddress, r.is_active, " +
            "r.recruitmentEmail, r.recruitmentNumphone, r.information, r.image_file " +
            "FROM Organization o JOIN RecruitmentOrganization r ON o.id = r.organization.id")
    List<Object[]> joinWithRecruitmentOrganization();
}

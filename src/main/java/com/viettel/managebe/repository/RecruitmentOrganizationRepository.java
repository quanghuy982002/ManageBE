package com.viettel.managebe.repository;

import com.viettel.managebe.model.RecruitmentOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentOrganizationRepository extends JpaRepository<RecruitmentOrganization, Long> {
    @Override
    List<RecruitmentOrganization> findAll();
}

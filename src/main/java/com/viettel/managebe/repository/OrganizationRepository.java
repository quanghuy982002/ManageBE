package com.viettel.managebe.repository;

import com.viettel.managebe.model.Organization;
import com.viettel.managebe.model.RecruitmentOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    List<Organization> findByParentIdIsNull();
    List<Organization> findByParentId(Long parentId);
    List<Organization> findAll();
}

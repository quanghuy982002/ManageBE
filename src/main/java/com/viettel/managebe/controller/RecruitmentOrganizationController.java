package com.viettel.managebe.controller;

import com.viettel.managebe.dto.RecruitmentOrganizationDTO;
import com.viettel.managebe.model.RecruitmentOrganization;
import com.viettel.managebe.repository.RecruitmentOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v3")
public class RecruitmentOrganizationController {
    @Autowired
    private RecruitmentOrganizationRepository recruitmentOrganizationRepository;

    @GetMapping("/recruitment_organization")
    public List<RecruitmentOrganizationDTO> getAllRecruitmentOrganization() {
        List<RecruitmentOrganization> organizations = recruitmentOrganizationRepository.findAll();

        List<RecruitmentOrganizationDTO> dtos = new ArrayList<>();
        for (RecruitmentOrganization organization : organizations) {
            RecruitmentOrganizationDTO dto = new RecruitmentOrganizationDTO();
            dto.setId(organization.getId());
            dto.setOrganizationId(organization.getOrganization().getId());
            dto.setRecruitmentName(organization.getRecruitmentName());
            dto.setRecruitmentEmail(organization.getRecruitmentEmail());
            dto.setRecruitmentNumphone(organization.getRecruitmentNumphone());
            dto.setInformation(organization.getInformation());
            dto.setScope(organization.getScope());
            dto.setOfficeAddress(organization.getOfficeAddress());
            dto.setActive(organization.is_active());
            dtos.add(dto);
        }
        return dtos;
    }

}

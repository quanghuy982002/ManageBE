package com.viettel.managebe.controller;

import com.viettel.managebe.dto.OrganizationRecruitmentDTO;
import com.viettel.managebe.model.RecruitmentOrganization;
import com.viettel.managebe.repository.RecruitmentOrganizationRepository;
import com.viettel.managebe.service.RecruitmentOrganizationService;
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

    @Autowired
    private RecruitmentOrganizationService recruitmentOrganizationService;
    @GetMapping("/join")
    public List<OrganizationRecruitmentDTO> getOrganizationRecruitments() {
        return recruitmentOrganizationService.getOrganizationRecruitments();
    }

}

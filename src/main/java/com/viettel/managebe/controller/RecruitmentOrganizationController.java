package com.viettel.managebe.controller;

import com.viettel.managebe.dto.RecruitmentOrganizationDTO;
import com.viettel.managebe.model.RecruitmentOrganization;
import com.viettel.managebe.repository.RecruitmentOrganizationRepository;
import com.viettel.managebe.service.RecruitmentOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v3")
public class RecruitmentOrganizationController {
    @Autowired
    private RecruitmentOrganizationRepository recruitmentOrganizationRepository;

    @Autowired
    private RecruitmentOrganizationService recruitmentOrganizationService;

    @GetMapping("/recruitment_organization")
    public List<RecruitmentOrganizationDTO> getAllRecruitmentOrganizations() {
        return recruitmentOrganizationService.getAllRecruitmentOrganizations();
    }

    @GetMapping("/recruitment_organization/{id}")
    public RecruitmentOrganizationDTO getRecruitmentOrganizationById(@PathVariable long id) {
        return recruitmentOrganizationService.getRecruitmentOrganizationById(id);
    }

    @PostMapping("/recruitment_organization")
    public RecruitmentOrganizationDTO createRecruitmentOrganization(@RequestBody RecruitmentOrganizationDTO dto) {
        return recruitmentOrganizationService.createRecruitmentOrganization(dto);
    }
    @PutMapping("/recruitment_organization/{id}")
    public RecruitmentOrganizationDTO updateRecruitmentOrganization(@PathVariable long id, @RequestBody RecruitmentOrganizationDTO dto) {
        return recruitmentOrganizationService.updateRecruitmentOrganization(id, dto);
    }
    @DeleteMapping("/recruitment_organization/{id}")
    public void deleteRecruitmentOrganization(@PathVariable long id) {
        recruitmentOrganizationService.deleteRecruitmentOrganization(id);
    }

//    //API join 2 table db
//    @GetMapping("/join")
//    public List<RecruitmentOrganizationDTO> getOrganizationRecruitments() {
//        return recruitmentOrganizationService.getOrganizationRecruitments();
//    }
}

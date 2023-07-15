package com.viettel.managebe.service;

import com.viettel.managebe.dto.OrganizationRecruitmentDTO;
import com.viettel.managebe.repository.RecruitmentOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RecruitmentOrganizationService {

    @Autowired
    private RecruitmentOrganizationRepository recruitmentOrganizationRepository;
    public List<OrganizationRecruitmentDTO> getOrganizationRecruitments() {
        List<OrganizationRecruitmentDTO> dtos = new ArrayList<>();

        List<Object[]> results = recruitmentOrganizationRepository.joinWithRecruitmentOrganization();

        for (Object[] result : results) {
            OrganizationRecruitmentDTO dto = new OrganizationRecruitmentDTO();
            dto.setOrganizationId((long) result[0]);
            dto.setOrganizationName((String) result[1]);
            dto.setEffectiveEndDate((Date) result[2]);
            dto.setEffectiveStartDate((Date) result[3]);
            dto.setScope((int) result[4]);
            dto.setOfficeAddress((String) result[5]);
            dto.setActive((boolean) result[6]);
            dtos.add(dto);
        }
        return dtos;
    }
}

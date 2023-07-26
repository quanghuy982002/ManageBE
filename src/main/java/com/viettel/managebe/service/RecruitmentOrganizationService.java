package com.viettel.managebe.service;

import com.viettel.managebe.dto.RecruitmentOrganizationDTO;
import com.viettel.managebe.model.Organization;
import com.viettel.managebe.model.RecruitmentOrganization;
import com.viettel.managebe.repository.RecruitmentOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecruitmentOrganizationService {

    @Autowired
    private RecruitmentOrganizationRepository recruitmentOrganizationRepository;

    public List<RecruitmentOrganization> getRO(){
        return recruitmentOrganizationRepository.findAll();
    }

    public List<RecruitmentOrganizationDTO> getAllRecruitmentOrganizations() {
        List<RecruitmentOrganization> entities = recruitmentOrganizationRepository.findAll();
        return entities.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public RecruitmentOrganizationDTO getRecruitmentOrganizationById(long id) {
        RecruitmentOrganization entity = recruitmentOrganizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruitment Organization not found with id: " + id));
        return convertToDto(entity);
    }

    public RecruitmentOrganizationDTO createRecruitmentOrganization(RecruitmentOrganizationDTO dto) {
        RecruitmentOrganization entity = convertToEntity(dto);
        RecruitmentOrganization savedEntity = recruitmentOrganizationRepository.save(entity);
        return convertToDto(savedEntity);
    }

    public void deleteRecruitmentOrganization(long id) {
        recruitmentOrganizationRepository.deleteById(id);
    }
    public RecruitmentOrganizationDTO updateRecruitmentOrganization(long id, RecruitmentOrganizationDTO dto) {
        RecruitmentOrganization existingEntity = recruitmentOrganizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruitment Organization not found with id: " + id));

        // Update fields in the existing entity from the DTO
        existingEntity.setRecruitmentName(dto.getRecruitmentName());
        existingEntity.setRecruitmentEmail(dto.getRecruitmentEmail());
        existingEntity.setRecruitmentNumphone(dto.getRecruitmentNumphone());
        existingEntity.setInformation(dto.getInformation());
        existingEntity.setScope(dto.getScope());
        existingEntity.setOfficeAddress(dto.getOfficeAddress());
        existingEntity.setIs_active(dto.isIs_active());
        existingEntity.setEffective_start_date(dto.getEffective_start_date());
        existingEntity.setEffective_end_date(dto.getEffective_end_date());
        existingEntity.setImage_file(dto.getImage_file());

        RecruitmentOrganization updatedEntity = recruitmentOrganizationRepository.save(existingEntity);
        return convertToDto(updatedEntity);
    }
    private RecruitmentOrganization convertToEntity(RecruitmentOrganizationDTO dto) {
        RecruitmentOrganization entity = new RecruitmentOrganization();
        Organization organization = new Organization();
        organization.setId(dto.getOrganizationId());
        entity.setOrganization(organization);
        entity.setRecruitmentName(dto.getRecruitmentName());
        entity.setRecruitmentEmail(dto.getRecruitmentEmail());
        entity.setRecruitmentNumphone(dto.getRecruitmentNumphone());
        entity.setInformation(dto.getInformation());
        entity.setScope(dto.getScope());
        entity.setOfficeAddress(dto.getOfficeAddress());
        entity.setIs_active(dto.isIs_active());
        entity.setEffective_start_date(dto.getEffective_start_date());
        entity.setEffective_end_date(dto.getEffective_end_date());
        entity.setImage_file(dto.getImage_file());
        return entity;
    }
    private RecruitmentOrganizationDTO convertToDto(RecruitmentOrganization entity) {
        RecruitmentOrganizationDTO dto = new RecruitmentOrganizationDTO();
        dto.setOrganizationId(entity.getOrganization().getId());
        dto.setRecruitmentName(entity.getRecruitmentName());
        dto.setRecruitmentEmail(entity.getRecruitmentEmail());
        dto.setRecruitmentNumphone(entity.getRecruitmentNumphone());
        dto.setInformation(entity.getInformation());
        dto.setScope(entity.getScope());
        dto.setOfficeAddress(entity.getOfficeAddress());
        dto.setIs_active(entity.isIs_active());
        dto.setEffective_start_date(entity.getEffective_start_date());
        dto.setEffective_end_date(entity.getEffective_end_date());
        dto.setImage_file(entity.getImage_file());
        return dto;
    }

//    public RecruitmentOrganization addRecruitmentOrganization(RecruitmentOrganizationDTO dto) {
//        RecruitmentOrganization recruitment = new RecruitmentOrganization();
//
//        recruitment.setRecruitmentName(dto.getRecruitmentName());
//        recruitment.setRecruitmentEmail(dto.getRecruitmentEmail());
//        recruitment.setRecruitmentNumphone(dto.getRecruitmentNumphone());
//        recruitment.setInformation(dto.getInformation());
//        recruitment.setScope(dto.getScope());
//        recruitment.setOfficeAddress(dto.getOfficeAddress());
//        recruitment.setIs_active(dto.isActive());
//
//        Organization organization = organizationRepository.findById(dto.getOrganizationId()).orElse(null);
//        if (organization != null) {
//            recruitment.setOrganization(organization);
//        } else {
//            throw new RuntimeException("Không tìm thấy Organization với id: " + dto.getOrganizationId());
//        }
//
//        return recruitmentOrganizationRepository.save(recruitment);
//    }
}
//    public List<RecruitmentOrganizationDTO> getOrganizationRecruitments() {
//        List<RecruitmentOrganizationDTO> dtos = new ArrayList<>();
//
//        List<Object[]> results = recruitmentOrganizationRepository.joinWithRecruitmentOrganization();
//
//        for (Object[] result : results) {
//            RecruitmentOrganizationDTO dto = new RecruitmentOrganizationDTO();
//            dto.setOrganizationId((long) result[0]);
//            dto.setRecruitmentName((String) result[1]);
//            dto.setEffective_end_date((Date) result[2]);
//            dto.setEffective_start_date((Date) result[3]);
//            dto.setScope((int) result[4]);
//            dto.setOfficeAddress((String) result[5]);
//            dto.setIs_active((boolean) result[6]);
//            dto.setRecruitmentEmail((String) result[7]);
//            dto.setRecruitmentNumphone((String) result[8]);
//            dto.setInformation((String) result[9]);
//            dto.setImage_file((String) result[10]);
//            dtos.add(dto);
//        }
//        return dtos;
//    }

package com.viettel.managebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentOrganizationDTO {
    private long id;
    private long organizationId;
    private String recruitmentName;
    private String recruitmentEmail;
    private String recruitmentNumphone;
    private String information;
    private int scope;

    private String officeAddress;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

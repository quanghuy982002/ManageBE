package com.viettel.managebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRecruitmentDTO {
    private long organizationId;
    private String organizationName;
    private Date effectiveStartDate;
    private Date effectiveEndDate;
    private int scope;
    private String officeAddress;
    private boolean isActive;
}

package com.viettel.managebe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentOrganizationDTO {
    private long organizationId;
    private String recruitmentName;
    private String recruitmentEmail;
    private String recruitmentNumphone;
    private String information;
    private int scope;
    private String officeAddress;
    private Date effective_start_date;
    private Date effective_end_date;
    private String image_file;
    private boolean is_active;

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public String getRecruitmentName() {
        return recruitmentName;
    }

    public void setRecruitmentName(String recruitmentName) {
        this.recruitmentName = recruitmentName;
    }

    public String getRecruitmentEmail() {
        return recruitmentEmail;
    }

    public void setRecruitmentEmail(String recruitmentEmail) {
        this.recruitmentEmail = recruitmentEmail;
    }

    public String getRecruitmentNumphone() {
        return recruitmentNumphone;
    }

    public void setRecruitmentNumphone(String recruitmentNumphone) {
        this.recruitmentNumphone = recruitmentNumphone;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Date getEffective_start_date() {
        return effective_start_date;
    }

    public void setEffective_start_date(Date effective_start_date) {
        this.effective_start_date = effective_start_date;
    }

    public Date getEffective_end_date() {
        return effective_end_date;
    }

    public void setEffective_end_date(Date effective_end_date) {
        this.effective_end_date = effective_end_date;
    }

    public String getImage_file() {
        return image_file;
    }

    public void setImage_file(String image_file) {
        this.image_file = image_file;
    }
}

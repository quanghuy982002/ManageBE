package com.viettel.managebe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "recruitment_organization")
public class RecruitmentOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;


    private String recruitmentName;
    private String recruitmentEmail;
    private String recruitmentNumphone;
    private String information;
    private int scope;
    private String officeAddress;
    private boolean is_active;
}

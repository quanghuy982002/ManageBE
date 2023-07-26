package com.viettel.managebe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "organization_id")
    private long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    private Long parentId;
    @Transient
    private List<Organization> children;

}



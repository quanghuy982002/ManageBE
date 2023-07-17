package com.viettel.managebe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "effective_date")
    private LocalDate effective_date;

    @Column(name = "expired_date")
    private LocalDate expired_date;

    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private CategoryType type;
}

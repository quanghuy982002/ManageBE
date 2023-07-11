package com.viettel.managebe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Table(name = "category_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryType {
    @Id
    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

}

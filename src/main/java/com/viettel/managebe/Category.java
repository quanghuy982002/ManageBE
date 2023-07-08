package com.viettel.managebe;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "status")
    private boolean status;

//    @ManyToOne(fetch = FetchType.LAZY) //LAZY không được tải luôn khi truy cập obj
//    @JoinColumn(name = "type_code", referencedColumnName = "code")
//    private CategoryType categoryType;
}

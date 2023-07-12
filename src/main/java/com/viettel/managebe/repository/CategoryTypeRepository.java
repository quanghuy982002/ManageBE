package com.viettel.managebe.repository;

import com.viettel.managebe.model.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {
    @Override
    List<CategoryType> findAll();
}

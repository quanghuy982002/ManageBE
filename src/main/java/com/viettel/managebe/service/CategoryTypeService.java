package com.viettel.managebe.service;

import com.viettel.managebe.model.CategoryType;
import com.viettel.managebe.repository.CategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryTypeService {

    @Autowired
    private CategoryTypeRepository categoryTypeRepository;

    public List<CategoryType> getAllCategoryTypes() {
        return categoryTypeRepository.findAll();
    }

    public CategoryType getCategoryTypeById(Long id) {
        return categoryTypeRepository.findById(id).orElse(null);
    }

    public CategoryType addCategoryType(CategoryType categoryType) {
        return categoryTypeRepository.save(categoryType);
    }

    public CategoryType updateCategoryType(CategoryType categoryType) {
        return categoryTypeRepository.save(categoryType);
    }

    public void deleteCategoryTypeById(Long id) {
        categoryTypeRepository.deleteById(id);
    }
}

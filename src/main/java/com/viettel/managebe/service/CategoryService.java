package com.viettel.managebe.service;

import com.viettel.managebe.dto.CategoryDTO;
import com.viettel.managebe.model.Category;
import com.viettel.managebe.model.CategoryType;
import com.viettel.managebe.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryTypeService categoryTypeService;


    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }
    public Category addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCode(categoryDTO.getCode());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        category.setEffective_date(categoryDTO.getEffectiveDate());
        category.setExpired_date(categoryDTO.getExpiredDate());
        category.setStatus(categoryDTO.isStatus());

        CategoryType categoryType = categoryTypeService.getCategoryTypeById(categoryDTO.getTypeId());
        category.setType(categoryType);

        return categoryRepository.save(category);
    }

}

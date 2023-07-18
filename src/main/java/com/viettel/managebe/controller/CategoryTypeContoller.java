package com.viettel.managebe.controller;

import com.viettel.managebe.model.CategoryType;
import com.viettel.managebe.repository.CategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v2")
public class CategoryTypeContoller {
    @Autowired
    private CategoryTypeRepository categoryTypeRepository;
    @GetMapping("/category_type")
    public List<CategoryType> getAllCategoryType()
    {
        return categoryTypeRepository.findAll();
    }
    @PostMapping("/category_type")
    public CategoryType createCategoryType(@RequestBody CategoryType categoryType){
        return categoryTypeRepository.save(categoryType);
    }

    @DeleteMapping("/category_type/{id}")
    public ResponseEntity<String> deleteCategoryType(@PathVariable Long id) {
        try {
            categoryTypeRepository.deleteById(id);
            return ResponseEntity.ok("Category type deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }


}

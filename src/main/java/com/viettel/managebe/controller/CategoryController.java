package com.viettel.managebe.controller;


import com.viettel.managebe.dto.CategoryDTO;
import com.viettel.managebe.service.CategoryService;
import com.viettel.managebe.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategory()
    {
        return categoryService.getCategory();
    }

    @PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO) {
        Category newCategory = categoryService.addCategory(categoryDTO);
        if (newCategory != null) {
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

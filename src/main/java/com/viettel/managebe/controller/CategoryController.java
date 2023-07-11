package com.viettel.managebe.controller;


import com.viettel.managebe.CategoryService;
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
//    @GetMapping("/category")
//    public ResponseEntity<List<Category>> listCategory()
//    {
//        List<Category> list = categoryService.getCategory();
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }

    @GetMapping("/category")
    public List<Category> getAllCategory()
    {
        return categoryService.getCategory();
    }

    @PostMapping("/addCategory")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

}

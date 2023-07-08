package com.viettel.managebe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<List<Category>> listCategory()
    {
        List<Category> list = categoryService.getCategory();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

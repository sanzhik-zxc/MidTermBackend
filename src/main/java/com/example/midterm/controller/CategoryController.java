package com.example.midterm.controller;

import com.example.midterm.dto.CategoryDTO;
import com.example.midterm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/new")
    public void createCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.creteNewCategory(categoryDTO);
    }
}

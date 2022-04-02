package com.example.midterm.service;

import com.example.midterm.dto.CategoryDTO;
import com.example.midterm.entity.Category;
import com.example.midterm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public void creteNewCategory(CategoryDTO categoryDTO){
        Category category=Category.builder()
                .name(categoryDTO.getName())
                .build();
        categoryRepository.save(category);
    }
}

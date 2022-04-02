package com.example.midterm.dto;


import com.example.midterm.entity.Category;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;

    private String name;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public CategoryDTO() {
    }
}

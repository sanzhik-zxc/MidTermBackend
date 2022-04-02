package com.example.midterm.dto;

import com.example.midterm.entity.Category;
import com.example.midterm.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateProductDTO {

    private String name;

    private Long categoryId;

    private int cost;


    public CreateProductDTO(Product product) {
        this.name = product.getName();
        this.categoryId = getCategoryId();
        this.cost = product.getCost();
    }

    public CreateProductDTO() {
    }
}

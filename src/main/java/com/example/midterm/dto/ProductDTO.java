package com.example.midterm.dto;

import com.example.midterm.entity.Category;
import com.example.midterm.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class ProductDTO {
    private Long id;

    private String name;

    private Category category;

    private int cost;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.category = product.getCategory();
        this.cost = product.getCost();
    }

    public ProductDTO() {
    }
}

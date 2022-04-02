package com.example.midterm.service;

import com.example.midterm.dto.CreateProductDTO;
import com.example.midterm.dto.ProductDTO;
import com.example.midterm.entity.Category;
import com.example.midterm.entity.Product;
import com.example.midterm.repository.CategoryRepository;
import com.example.midterm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public void createNewProduct(CreateProductDTO createProductDTO){

        Optional<Category> category = categoryRepository.findById(createProductDTO.getCategoryId());

        Product product = Product
                .builder()
                .name(createProductDTO.getName())
                .category(category.get())
                .cost(createProductDTO.getCost())
                .build();

        productRepository.save(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productDTOS=productRepository.findAll();
        List<ProductDTO> products = productDTOS
                .stream()
                .map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
        return products;
    }
    
    public Product findProductById(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Product> productExist = productRepository.findById(id);
        if(productExist.isPresent()){
            return productExist.get();
        }
        else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}

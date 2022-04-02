package com.example.midterm.controller;

import com.example.midterm.dto.CreateProductDTO;
import com.example.midterm.dto.ProductDTO;
import com.example.midterm.entity.Product;
import com.example.midterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "product")
public class ProductController {


    @Autowired
    ProductService productService;

    @PostMapping(value = "/new")
    public ResponseEntity createProduct(@RequestBody CreateProductDTO createProductDTO){
        productService.createNewProduct(createProductDTO);
        return ResponseEntity.ok("Success");
    }

    @GetMapping
    public ResponseEntity<List> getAllProducts(){
        List <ProductDTO>productDTOS=productService.getAllProducts();
        return ResponseEntity.ok(productDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Product productExist = productService.findProductById(id);
        ProductDTO productDTO=new ProductDTO(productExist);
        return ResponseEntity.ok(productDTO);
    }
}

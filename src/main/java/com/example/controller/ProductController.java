package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService ProductService;
    
    public ProductController() {
        System.out.println("ProductController initialized with ProductService: " + ProductService);
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Product> categories = ProductService.getAllProducts(pageable);
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product Product) {
        Product createdProduct = ProductService.createProduct(Product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product Product = ProductService.getProductById(id);
        return ResponseEntity.ok(Product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product ProductDetails) {
        Product updatedProduct = ((ProductService) ProductService).updateProduct(id, ProductDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        ProductService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	 public ProductService() {
	        System.out.println("ProductService initialized!");
	    }
    @Autowired
    private ProductRepository ProductRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return ProductRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return ProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product createProduct(Product Product) {
        return ProductRepository.save(Product);
    }

    public Product updateProduct(Long id, Product ProductDetails) {
        Product Product = getProductById(id);
        Product.setName(ProductDetails.getName());
        return ProductRepository.save(Product);
    }

    public void deleteProduct(Long id) {
        ProductRepository.deleteById(id);
    }
}

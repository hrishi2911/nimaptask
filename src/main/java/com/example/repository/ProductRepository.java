package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.Product;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // No additional methods are required as JpaRepository already provides findAll(Pageable)
}


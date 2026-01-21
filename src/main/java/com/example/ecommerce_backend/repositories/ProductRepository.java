package com.example.ecommerce_backend.repositories;

import com.example.ecommerce_backend.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}

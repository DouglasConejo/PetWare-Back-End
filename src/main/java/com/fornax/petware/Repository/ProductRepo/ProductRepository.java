package com.fornax.petware.Repository.ProductRepo;

import com.fornax.petware.Entity.ProductPackage.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);


}

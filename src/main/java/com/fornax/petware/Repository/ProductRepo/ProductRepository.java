package com.fornax.petware.Repository.ProductRepo;
import com.fornax.petware.Entity.ProductPackage.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT v.name, v.price, v.description,v.image FROM Product v")
    List<String[]> findProduct();
}

package com.fornax.petware.Controller.ProductContro;

import com.fornax.petware.Entity.ProductPackage.Product;
import com.fornax.petware.Entity.QuotePackage.Quote;
import com.fornax.petware.Entity.VaccinePackage.Vaccine;
import com.fornax.petware.Repository.ProductRepo.ProductRepository;
import com.fornax.petware.Repository.VaccineRepo.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("product")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("products")
    public List<Product> getAllPet() {
        List<String[]> queryResponse = productRepository.findProduct();
        ArrayList<Product> products= new ArrayList<>();
        queryResponse.forEach(p -> {
            Product product= new Product();
            product.setDescription((p[1]));
            product.setName((p[2]));
            product.setImage((p[2]));
            product.setPrice(Double.parseDouble((p[2])));

            products.add(product);
        });
        return products;
    }

}

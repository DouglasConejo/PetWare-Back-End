package com.fornax.petware.Controller.ProductContro;

import com.fornax.petware.Entity.ProductPackage.Product;
import com.fornax.petware.Repository.ProductRepo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id,
                                                 @RequestBody Product productUpdate) {

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setName(productUpdate.getName());
            existingProduct.setDescription(productUpdate.getDescription());
            existingProduct.setPrice(productUpdate.getPrice());
            existingProduct.setImage(productUpdate.getImage());

            Product updatedProduct = productRepository.save(existingProduct);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<List<Product>> findProductsByName(@PathVariable String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);

        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

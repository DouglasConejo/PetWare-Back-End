package com.fornax.petware.service;

import com.fornax.petware.Entity.ProductPackage.Product;
import com.fornax.petware.Entity.UserPackage.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productStringData;

    public ProductService(){
        productStringData = new LinkedList<>();
    }

    public Product adduser(Product product){
        product.setId(1L);
        product.setName("test name product");
        product.setDescription("descrip test");
        product.setImage("Test image");
        product.setPrice(200.2);
        this.productStringData.add(product);
        return product;
    }

    public List<Product> getAllUsers(){
        return productStringData;
    }


}

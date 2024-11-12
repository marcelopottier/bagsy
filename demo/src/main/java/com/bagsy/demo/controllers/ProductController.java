package com.bagsy.demo.controllers;

import com.bagsy.demo.domain.products.Product;
import com.bagsy.demo.domain.products.ProductRepository;
import com.bagsy.demo.domain.products.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        try{
            var allProducts = repository.findAll();
            return ResponseEntity.ok(allProducts);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid RequestProduct data){
        Product newProduct =  new Product(data);
        return ResponseEntity.ok().build();
    }
}

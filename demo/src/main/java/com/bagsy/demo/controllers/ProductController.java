package com.bagsy.demo.controllers;

import com.bagsy.demo.domain.products.Product;
import com.bagsy.demo.domain.products.ProductRepository;
import com.bagsy.demo.domain.products.CreateProductDTO;
import com.bagsy.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getAllProducts(){
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid CreateProductDTO createProductDTO){
        var productId = productService.createProduct(createProductDTO);
        return ResponseEntity.created(URI.create("/product/"+ productId.toString())).build();
    }
}

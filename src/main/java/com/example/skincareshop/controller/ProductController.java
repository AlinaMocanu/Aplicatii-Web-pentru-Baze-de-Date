package com.example.skincareshop.controller;

import com.example.skincareshop.dto.ProductDto;
import com.example.skincareshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity
                .ok()
                .body(productService.getAllProducts());
    }

    @GetMapping("/name/{Name}")
    public ResponseEntity<ProductDto> getProductByName(@PathVariable String Name) {
        return ResponseEntity
                .ok()
                .body(productService.getOne(Name));
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/update")
    public void updateProduct( @RequestParam Long id, @RequestParam String name, @RequestParam Double price, @RequestParam Long quantity, @RequestParam Long supplierId) {
        productService.updateProduct(id, name, price, quantity, supplierId);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity
                .ok()
                .body(productService.createProduct(productDto));
    }
}

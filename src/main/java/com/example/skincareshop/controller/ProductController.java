package com.example.skincareshop.controller;

import com.example.skincareshop.dto.ProductDto;
import com.example.skincareshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping("/list")
    public ModelAndView productsList(){
        ModelAndView modelAndView = new ModelAndView("products");
        List<ProductDto> products = productService.getAllProducts();
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/product/info/{id}")
    public ModelAndView showByName(@PathVariable Long id, Model model) {
        ModelAndView modelAndView = new ModelAndView("productInfo");
        ProductDto product = productService.getById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("product/delete/{id}")
    public RedirectView deleteProduct(@PathVariable String id) {

        productService.deleteProduct(Long.valueOf(id));
        return new RedirectView("/products/list");
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

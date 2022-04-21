package com.example.skincareshop.repository;


import com.example.skincareshop.domain.Product;
import com.example.skincareshop.domain.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Order(1)
    public void addProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(60.0);
        product.setQuantity(Long.valueOf(200));
        product.setSupplier(new Supplier(Long.valueOf(3), "Greenland", "Rome", new ArrayList<Product>()));
        productRepository.save(product);
    }


    @Test
    @Order(2)
    public void findByName() {
        Product product = productRepository.findProductByName("Test Product");
        assertFalse(product == null);
        log.info("findProductByName ...");
        log.info(product.getName());
    }

    @Test
    @Order(3)
    public void updateProduct() {
        Product product = productRepository.findProductByName("Test Product");
        product.setPrice(70.0);
        productRepository.updateProduct(product.getId(), product.getName(), product.getPrice(), product.getQuantity(), product.getSupplier().getId());
        Product updatedProduct = productRepository.findProductByName("Test Product");
        assertTrue(updatedProduct.getPrice() == 70.0);
    }

    @Test
    @Order(4)
    public void deleteProduct() {
        Product product = productRepository.findProductByName("Test Product");
        productRepository.deleteProduct(product.getId());
        Product deletedProduct = productRepository.findProductByName("Test Product");
        assertTrue(deletedProduct == null);
    }

    @Test
    @Order(5)
    public void findAll() {
        List<Product> products = productRepository.findAll();
        assertFalse(products.isEmpty());
        log.info("findAll ...");
        products.forEach(product -> log.info(product.getName()));
    }
}

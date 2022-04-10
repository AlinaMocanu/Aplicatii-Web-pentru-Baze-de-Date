package com.example.skincareshop.service;


import com.example.skincareshop.domain.Product;
import com.example.skincareshop.dto.ProductDto;
import com.example.skincareshop.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void findProducts() {
        List<Product> productsRet = new ArrayList<Product>();
        Product product = new Product();
        product.setId(4L);
        product.setName("TEST");
        productsRet.add(product);

        when(productRepository.findAll()).thenReturn(productsRet);
        List<ProductDto> products = productService.getAllProducts();
        Assertions.assertEquals(products.size(), 1);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void findProductByName() {
        Product product = new Product();
        product.setId(4L);
        product.setName("TEST");

        when(productRepository.findProductByName("TEST")).thenReturn(product);
        ProductDto products = productService.getOne("TEST");
        Assertions.assertEquals(products.getName(), "TEST");
        verify(productRepository, times(1)).findProductByName("TEST");
    }

}

package com.example.skincareshop.service;


import com.example.skincareshop.domain.Product;
import com.example.skincareshop.dto.ProductDto;
import com.example.skincareshop.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void noProductsReturnedTest() {
        given(productRepository.findAll()).willReturn(Collections.emptyList());

        List<ProductDto> products = productService.getAllProducts();

        assertTrue(products.isEmpty());
    }

    @Test
    public void nProductsAreFoundTest() {
        List<Product> products = Arrays.asList(new Product());

        given(productRepository.findAll()).willReturn(products);

        List<ProductDto> res = productService.getAllProducts();

        assertEquals(1, res.size());
    }


}

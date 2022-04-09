package com.example.skincareshop.controller;

import com.example.skincareshop.domain.OrderItem;
import com.example.skincareshop.domain.Product;
import com.example.skincareshop.domain.Supplier;
import com.example.skincareshop.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void getProductByNameTest() throws Exception {

        Product product = new Product( Integer.toUnsignedLong(1), "test", 35.0,Integer.toUnsignedLong(200), new Supplier(), new ArrayList<OrderItem>());

        given(productRepository.findProductByName("test")).willReturn(product);

        mockMvc.perform(get("/products/name/{Name}", "test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"))
                .andExpect(jsonPath("$.quantity").value(200))
                .andExpect(jsonPath("$.price").value(35.0));

    }
}

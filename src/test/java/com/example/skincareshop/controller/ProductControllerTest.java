package com.example.skincareshop.controller;

import com.example.skincareshop.domain.OrderItem;
import com.example.skincareshop.domain.Product;
import com.example.skincareshop.domain.Supplier;
import com.example.skincareshop.dto.ProductDto;
import com.example.skincareshop.repository.ProductRepository;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
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

    @Test
    public void getAllProductsTest() throws Exception {

        List<Product> products = new ArrayList<Product>();
        Product product = new Product( Integer.toUnsignedLong(1), "test", 35.0,Integer.toUnsignedLong(200), new Supplier(), new ArrayList<OrderItem>());

        Product product2 = new Product( Integer.toUnsignedLong(2), "new test Product", 35.0,Integer.toUnsignedLong(300), new Supplier(), new ArrayList<OrderItem>());

        products.add(product);
        products.add(product2);
        given(productRepository.findAll()).willReturn(products);

        mockMvc.perform(get("/products/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("test"))
                .andExpect(jsonPath("$[0].quantity").value(200))
                .andExpect(jsonPath("$[0].price").value(35.0))
                .andExpect(jsonPath("$[1].name").value("new test Product"))
                .andExpect(jsonPath("$[1].quantity").value(300))
                .andExpect(jsonPath("$[1].price").value(35.0));


    }

    @Test
    public void createProductTest() throws Exception {

        ProductDto productDto = new ProductDto( Integer.toUnsignedLong(1), "test", 35.0,Integer.toUnsignedLong(200), "Greenland", Long.valueOf(3),  "Rome");
        Product product = new Product( Integer.toUnsignedLong(1), "test", 35.0,Integer.toUnsignedLong(200), new Supplier(), new ArrayList<OrderItem>());

        given(productRepository.save(product)).willReturn(product);

        mockMvc.perform( MockMvcRequestBuilders
                        .post("/products/create")
                        .content(new Gson().toJson(productDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
}

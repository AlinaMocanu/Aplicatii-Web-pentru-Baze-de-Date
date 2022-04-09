package com.example.skincareshop.controller;

import com.example.skincareshop.dto.OrderDto;
import com.example.skincareshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getOrdersByUser(@RequestParam Long id) {
        return ResponseEntity
                .ok()
                .body(orderService.getOrdersByUser(id));
    }
}

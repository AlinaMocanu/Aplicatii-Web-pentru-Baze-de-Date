package com.example.skincareshop.controller;

import com.example.skincareshop.dto.OrderItemDto;
import com.example.skincareshop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("/orderitems")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderItemDto>> getOrderItemsByOrders(@RequestParam Long id) {
        return ResponseEntity
                .ok()
                .body(orderItemService.getOrderItemsByOrder(id));
    }
}

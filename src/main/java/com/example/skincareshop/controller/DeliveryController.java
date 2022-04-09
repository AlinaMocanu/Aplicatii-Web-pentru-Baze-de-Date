package com.example.skincareshop.controller;

import com.example.skincareshop.dto.DeliveryDto;
import com.example.skincareshop.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/order/{id}")
    public ResponseEntity<DeliveryDto> getDeliveryWithOrder(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(deliveryService.getDeliveryWithOrder(id));
    }
}

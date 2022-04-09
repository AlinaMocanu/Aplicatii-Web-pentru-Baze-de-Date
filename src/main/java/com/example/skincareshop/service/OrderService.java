package com.example.skincareshop.service;

import com.example.skincareshop.domain.Order;
import com.example.skincareshop.dto.OrderDto;
import com.example.skincareshop.mapper.OrderMapper;
import com.example.skincareshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getOrdersByUser(Long id) {
        List<Order> orders = orderRepository.findOrdersByUserId(id);
        return orders.stream().map(o -> orderMapper.mapToDto(o)).collect(Collectors.toList());

    }

}

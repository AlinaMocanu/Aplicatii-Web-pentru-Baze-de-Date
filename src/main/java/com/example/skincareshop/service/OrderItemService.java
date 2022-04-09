package com.example.skincareshop.service;

import com.example.skincareshop.domain.OrderItem;
import com.example.skincareshop.dto.OrderItemDto;
import com.example.skincareshop.mapper.OrderItemMapper;
import com.example.skincareshop.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    public List<OrderItemDto> getOrderItemsByOrder(Long id) {
        List<OrderItem> orderItems = orderItemRepository.findOrderItemsByOrderId(id);
        return orderItems.stream().map(o -> orderItemMapper.mapToDto(o)).collect(Collectors.toList());

    }

    @Transactional
    public void deleteProductReference(Long id) {
       orderItemRepository.deleteProductReference(id);
    }

}

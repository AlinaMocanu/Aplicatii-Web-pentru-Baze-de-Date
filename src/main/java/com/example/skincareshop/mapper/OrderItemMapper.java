package com.example.skincareshop.mapper;

import com.example.skincareshop.domain.OrderItem;
import com.example.skincareshop.dto.OrderItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productName", source = "product.name")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "quantity", source = "quantity")
    OrderItemDto mapToDto(OrderItem orderItem);

    @Mapping(target = "order.id", source = "orderId")
    @Mapping(target = "product.id", source = "productId")
    @Mapping(target = "product.name", source = "productName")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "quantity", source = "quantity")
    OrderItem mapToEntity(OrderItemDto orderItem);
}

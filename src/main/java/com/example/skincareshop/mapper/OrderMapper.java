package com.example.skincareshop.mapper;

import com.example.skincareshop.domain.Order;
import com.example.skincareshop.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "total", source = "total")
    @Mapping(target = "placementDate", source = "placementDate")
    @Mapping(target = "id", source = "id")
    OrderDto mapToDto(Order order);

    @Mapping(target = "total", source = "total")
    @Mapping(target = "placementDate", source = "placementDate")
    @Mapping(target = "id", source = "id")
    Order mapToEntity(OrderDto order);
}

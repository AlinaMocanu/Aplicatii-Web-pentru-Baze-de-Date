package com.example.skincareshop.mapper;

import com.example.skincareshop.domain.Delivery;
import com.example.skincareshop.dto.DeliveryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "placementDate", source = "order.placementDate")
    @Mapping(target = "total", source = "order.total")
    DeliveryDto mapToDto(Delivery delivery);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "order.id", source = "orderId")
    @Mapping(target = "order.placementDate", source = "placementDate")
    @Mapping(target = "order.total", source = "total")
    Delivery mapToEntity(DeliveryDto delivery);
}

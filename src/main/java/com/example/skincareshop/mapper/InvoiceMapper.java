package com.example.skincareshop.mapper;

import com.example.skincareshop.domain.Invoice;
import com.example.skincareshop.dto.InvoiceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "generationDate", source = "generationDate")
    @Mapping(target = "totalPrice", source = "totalPrice")
    @Mapping(target = "orderId", source = "order.id")
    @Mapping(target = "placementDate", source = "order.placementDate")
    @Mapping(target = "total", source = "order.total")
    InvoiceDto mapToDto(Invoice invoice);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "generationDate", source = "generationDate")
    @Mapping(target = "totalPrice", source = "totalPrice")
    @Mapping(target = "order.id", source = "orderId")
    @Mapping(target = "order.placementDate", source = "placementDate")
    @Mapping(target = "order.total", source = "total")
    Invoice mapToEntity(InvoiceDto invoice);
}

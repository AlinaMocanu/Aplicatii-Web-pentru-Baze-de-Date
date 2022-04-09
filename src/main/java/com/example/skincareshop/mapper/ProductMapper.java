package com.example.skincareshop.mapper;

import com.example.skincareshop.domain.Product;
import com.example.skincareshop.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "supplierName", source = "supplier.name")
    @Mapping(target = "city", source = "supplier.city")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "supplierId", source = "supplier.id")
    ProductDto mapToDto(Product product);

    @Mapping(target = "supplier.name", source = "supplierName")
    @Mapping(target = "supplier.city", source = "city")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "supplier.id", source = "supplierId")
    Product mapToEntity(ProductDto product);
}

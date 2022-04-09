package com.example.skincareshop.mapper;

import com.example.skincareshop.domain.Supplier;
import com.example.skincareshop.dto.SupplierDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "id", source = "id")
    SupplierDto mapToDto(Supplier supplier);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "id", source = "id")
    Supplier mapToEntity(SupplierDto supplier);
}

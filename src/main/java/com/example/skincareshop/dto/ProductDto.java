package com.example.skincareshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;

    @Size(min = 3, max = 200)
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Positive
    private Double price;

    private Long quantity;

    private String supplierName;

    private Long supplierId;

    private String city;
}

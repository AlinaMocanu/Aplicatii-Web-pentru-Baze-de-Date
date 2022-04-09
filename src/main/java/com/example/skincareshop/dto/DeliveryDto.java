package com.example.skincareshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDto {
    private Long id;

    private Date date;

    private String address;

    private Long orderId;

    private Date placementDate;

    private Double total;
}

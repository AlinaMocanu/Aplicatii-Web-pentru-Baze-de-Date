package com.example.skincareshop.dto;

import com.example.skincareshop.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;

    private Date generationDate;

    private Double totalPrice;

    private Long orderId;

    private Date placementDate;

    private Double total;
}

package com.example.skincareshop.service;

import com.example.skincareshop.domain.Delivery;
import com.example.skincareshop.dto.DeliveryDto;
import com.example.skincareshop.exception.DeliveryNotFoundException;
import com.example.skincareshop.mapper.DeliveryMapper;
import com.example.skincareshop.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DeliveryMapper deliveryMapper;

    public DeliveryDto getDeliveryWithOrder(Long id) {
        Optional<Delivery> delivery = Optional.ofNullable(deliveryRepository.findDeliveryById(id));

        if (delivery.isEmpty()) {
                throw new DeliveryNotFoundException("This delivery does not exist");
        }

        return deliveryMapper.mapToDto(delivery.get());
    }
}

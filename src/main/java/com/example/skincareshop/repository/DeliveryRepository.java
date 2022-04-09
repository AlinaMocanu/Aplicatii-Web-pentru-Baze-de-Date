package com.example.skincareshop.repository;

import com.example.skincareshop.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Delivery findDeliveryById(Long id);
}

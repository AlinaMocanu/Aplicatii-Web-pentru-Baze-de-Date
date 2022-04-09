package com.example.skincareshop.repository;

import com.example.skincareshop.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findOrderItemsByOrderId(Long id);

    @Modifying
    @Query(value = "DELETE FROM OrderItem o WHERE o.product.id = :idProduct")
    void deleteProductReference(Long idProduct);
}

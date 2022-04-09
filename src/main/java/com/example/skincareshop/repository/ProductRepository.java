package com.example.skincareshop.repository;

import com.example.skincareshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAll();

    Product findProductByName(String Name);

    @Modifying
    @Query(value = "DELETE FROM Product p WHERE p.id = :idProduct")
    void deleteProduct(Long idProduct);

    @Modifying
    @Query(value = "UPDATE Product p SET p.name = :name, p.price = :price, p.quantity = :quantity, p.supplier.id = :supplierId where p.id = :id")
    void updateProduct(Long id, String name, Double price, Long quantity, Long supplierId);

    @Modifying
    @Query(value = "DELETE FROM Product p WHERE p.supplier.id = :id")
    void removeSupplierReference(Long id);

    Product save(Product savedProduct);
}

package com.example.skincareshop.repository;

import com.example.skincareshop.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findAll();

    Supplier findSupplierByName(String Name);

    void deleteById(Long idSupplier);

    @Modifying
    @Query(value = "UPDATE Supplier s SET s.name = :name, s.city = :city where s.id = :id")
    void updateSupplier(Long id, String name, String city);

    Supplier save(Supplier savedSupplier);
}

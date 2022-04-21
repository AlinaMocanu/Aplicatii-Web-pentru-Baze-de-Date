package com.example.skincareshop.repository;

import com.example.skincareshop.domain.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("h2")
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class SupplierRepositoryTest {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    @Order(1)
    public void addSupplier() {
        Supplier supplier = new Supplier();
        supplier.setName("Test Supplier");
        supplier.setCity("Rome");
        supplierRepository.save(supplier);
    }

    @Test
    @Order(2)
    public void findByName() {
        Supplier supplier = supplierRepository.findSupplierByName("Test Supplier");
        assertFalse(supplier == null);
        log.info("findSupplierByName ...");
        log.info(supplier.getName());
    }

    @Test
    @Order(3)
    public void updateSupplier() {
        Supplier supplier = supplierRepository.findSupplierByName("Test Supplier");
        supplier.setCity("Paris");
        supplierRepository.updateSupplier(supplier.getId(), supplier.getName(), supplier.getCity());
        Supplier updatedSupplier = supplierRepository.findSupplierByName("Test Supplier");
        assertTrue(updatedSupplier.getCity() == "Paris");
    }

    @Test
    @Order(4)
    public void deleteSupplier() {
        Supplier supplier = supplierRepository.findSupplierByName("Test Supplier");
        supplierRepository.deleteById(supplier.getId());
        Supplier deletedSupplier = supplierRepository.findSupplierByName("Test Supplier");
        assertTrue(deletedSupplier == null);
    }

    @Test
    @Order(5)
    public void findAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        assertFalse(suppliers.isEmpty());
        log.info("findAll ...");
        suppliers.forEach(supplier -> log.info(supplier.getName()));
    }
}

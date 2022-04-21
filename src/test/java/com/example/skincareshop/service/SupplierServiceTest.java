package com.example.skincareshop.service;

import com.example.skincareshop.domain.Supplier;
import com.example.skincareshop.dto.SupplierDto;
import com.example.skincareshop.repository.SupplierRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupplierServiceTest {
    @MockBean
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierService supplierService;

    @Test
    public void findSuppliers() {
        List<Supplier> suppliersRet = new ArrayList<Supplier>();
        Supplier supplier = new Supplier();
        supplier.setId(4L);
        supplier.setName("TEST");
        supplier.setCity("Rome");
        suppliersRet.add(supplier);

        when(supplierRepository.findAll()).thenReturn(suppliersRet);
        List<SupplierDto> suppliers = supplierService.getAllSuppliers();
        Assertions.assertEquals(suppliers.size(), 1);
        verify(supplierRepository, times(1)).findAll();
    }

    @Test
    public void findSupplierByName() {
        Supplier supplier = new Supplier();
        supplier.setId(4L);
        supplier.setName("TEST");
        supplier.setCity("Paris");

        when(supplierRepository.findSupplierByName("TEST")).thenReturn(supplier);
        SupplierDto suppliers = supplierService.getOne("TEST");
        Assertions.assertEquals(suppliers.getName(), "TEST");
        verify(supplierRepository, times(1)).findSupplierByName("TEST");
    }

    @Test
    public void createSupplier() {
        Supplier supplier = new Supplier();
        supplier.setId(4L);
        supplier.setName("TEST");
        supplier.setCity("Paris");

        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setId(4L);
        supplierDto.setName("TEST");
        supplierDto.setCity("Paris");

        when(supplierRepository.save(supplier)).thenReturn(supplier);
        SupplierDto supplierDto2 = supplierService.createSupplier(supplierDto);
        verify(supplierRepository, times(1)).save(supplier);

    }

}

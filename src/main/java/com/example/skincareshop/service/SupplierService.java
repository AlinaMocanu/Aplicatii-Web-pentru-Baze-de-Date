package com.example.skincareshop.service;

import com.example.skincareshop.domain.Supplier;
import com.example.skincareshop.dto.SupplierDto;
import com.example.skincareshop.exception.SupplierNotFoundException;
import com.example.skincareshop.mapper.SupplierMapper;
import com.example.skincareshop.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierMapper supplierMapper;

    @Autowired
    private ProductService productService;


    public List<SupplierDto> getAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream().map(s -> supplierMapper.mapToDto(s)).collect(Collectors.toList());

    }

    public SupplierDto getOne(String Name) {
        Optional<Supplier> supplier = Optional.ofNullable(supplierRepository.findSupplierByName(Name));
        if (supplier.isEmpty()) {
            throw new SupplierNotFoundException("This supplier does not exist");
        }
        return supplierMapper.mapToDto(supplier.get());
    }

    @Transactional
    public void deleteSupplier(Long id) {
        productService.removeSupplierReference(id);
        supplierRepository.deleteById(id);
    }

    @Transactional
    public void updateSupplier(Long id, String name, String city) {
        supplierRepository.updateSupplier(id, name, city);
    }

    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = supplierMapper.mapToEntity(supplierDto);
        Supplier savedSupplier = supplierRepository.save(supplier);

        return supplierMapper.mapToDto(savedSupplier);
    }
}

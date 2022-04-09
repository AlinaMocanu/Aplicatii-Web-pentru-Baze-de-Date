package com.example.skincareshop.controller;

import com.example.skincareshop.dto.SupplierDto;
import com.example.skincareshop.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/all")
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
        return ResponseEntity
                .ok()
                .body(supplierService.getAllSuppliers());
    }

    @GetMapping("/name/{Name}")
    public ResponseEntity<SupplierDto> getSupplierByName(@PathVariable String Name) {
        return ResponseEntity
                .ok()
                .body(supplierService.getOne(Name));
    }

    @DeleteMapping("/delete")
    public void deleteSupplier(@RequestParam Long id) {
        supplierService.deleteSupplier(id);
    }

    @PutMapping("/update")
    public void updateSupplier( @RequestParam Long id, @RequestParam String name, @RequestParam String city) {
        supplierService.updateSupplier(id, name, city);
    }

    @PostMapping("/create")
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierDto supplierDto) {
        return ResponseEntity
                .ok()
                .body(supplierService.createSupplier(supplierDto));
    }
}

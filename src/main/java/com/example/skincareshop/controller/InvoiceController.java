package com.example.skincareshop.controller;

import com.example.skincareshop.dto.InvoiceDto;
import com.example.skincareshop.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/order/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceWithOrder(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(invoiceService.getInvoiceWithOrder(id));
    }
}

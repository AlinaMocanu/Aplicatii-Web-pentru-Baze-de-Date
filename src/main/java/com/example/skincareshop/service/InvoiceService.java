package com.example.skincareshop.service;

import com.example.skincareshop.domain.Invoice;
import com.example.skincareshop.dto.InvoiceDto;
import com.example.skincareshop.exception.InvoiceNotFoundException;
import com.example.skincareshop.mapper.InvoiceMapper;
import com.example.skincareshop.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceMapper invoiceMapper;

    public InvoiceDto getInvoiceWithOrder(Long id) {
        Optional<Invoice> invoice = Optional.ofNullable(invoiceRepository.findInvoiceById(id));

        if (invoice.isEmpty()) {
            throw new InvoiceNotFoundException("This invoice does not exist");
        }

        return invoiceMapper.mapToDto(invoice.get());
    }
}

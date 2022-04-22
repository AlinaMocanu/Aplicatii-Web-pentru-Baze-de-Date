package com.example.skincareshop.service;

import com.example.skincareshop.domain.Invoice;
import com.example.skincareshop.dto.InvoiceDto;
import com.example.skincareshop.exception.InvoiceNotFoundException;
import com.example.skincareshop.mapper.InvoiceMapper;
import com.example.skincareshop.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<InvoiceDto> getAllByTotalPriceDesc() {
        PageRequest sortedByTotalPriceDesc = PageRequest.of(0, 3, Sort.by("totalPrice").descending());
        Page<Invoice> allInvoicesSorted = invoiceRepository.findAll(sortedByTotalPriceDesc);

        return allInvoicesSorted.getContent().stream().map(i -> invoiceMapper.mapToDto(i)).collect(Collectors.toList());

    }
}

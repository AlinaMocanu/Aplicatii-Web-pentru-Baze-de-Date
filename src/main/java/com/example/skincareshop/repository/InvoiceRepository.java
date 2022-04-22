package com.example.skincareshop.repository;

import com.example.skincareshop.domain.Invoice;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {

    Invoice findInvoiceById(Long id);

    Page<Invoice> findAll(Pageable pageable);

}

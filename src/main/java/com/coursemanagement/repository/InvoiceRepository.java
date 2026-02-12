package com.coursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coursemanagement.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}

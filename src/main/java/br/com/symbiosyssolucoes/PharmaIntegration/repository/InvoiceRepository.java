package br.com.symbiosyssolucoes.PharmaIntegration.repository;


import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Optional<List<Invoice>> findByStatus(String status);
 }

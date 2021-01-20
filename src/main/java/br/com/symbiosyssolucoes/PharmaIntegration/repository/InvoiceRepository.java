package br.com.symbiosyssolucoes.PharmaIntegration.repository;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}

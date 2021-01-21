package br.com.symbiosyssolucoes.PharmaIntegration.repository;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.ConnectionsTypes;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {


}

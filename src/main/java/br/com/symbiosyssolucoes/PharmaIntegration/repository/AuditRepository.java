package br.com.symbiosyssolucoes.PharmaIntegration.repository;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}

package br.com.symbiosyssolucoes.PharmaIntegration.repository;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.ConnectionsTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConnectionsRepository extends JpaRepository<Connections, Long> {
//
//    @Query("SELECT c FROM Connections c WHERE c.Origin = :origin")
//    List<Connections> findByOrigin(String origin);
    @Query("SELECT c FROM Connections c WHERE c.Description = :description")
    List<Connections> findByDescription(String description);

}

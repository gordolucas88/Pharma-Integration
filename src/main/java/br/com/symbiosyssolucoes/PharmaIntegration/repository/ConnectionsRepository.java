package br.com.symbiosyssolucoes.PharmaIntegration.repository;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.ConnectionsTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConnectionsRepository extends JpaRepository<Connections, Long> {

    List<Connections> findByOriginEqual(ConnectionsTypes connectionsTypes);
}

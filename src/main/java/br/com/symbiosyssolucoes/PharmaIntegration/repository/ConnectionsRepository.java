package br.com.symbiosyssolucoes.PharmaIntegration.repository;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.ConnectionsTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.annotation.Native;
import java.util.List;

public interface ConnectionsRepository extends JpaRepository<Connections, Long> {

}

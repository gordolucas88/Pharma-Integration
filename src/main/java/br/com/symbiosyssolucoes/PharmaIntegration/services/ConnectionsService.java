package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.ConnectionsTypes;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.ConnectionsRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectionsService {
    private ConnectionsRepository connectionsRepository;
    private AuditService auditService;
    private ConnectionsTypes connectionsTypes;

    public ConnectionsService(ConnectionsRepository connectionsRepository, AuditService auditService, ConnectionsTypes connectionsTypes){
        this.connectionsRepository = connectionsRepository;
        this.auditService = auditService;
        this.connectionsTypes = connectionsTypes;

    }

    private Optional<Connections> listConnectionsById(Long id){

        Optional<Connections> connections = this.connectionsRepository.findById(id);

        return connections;
    }

    private Optional<List<Connections>> listConnectionsByOrigin(String origin){

        Optional<List<Connections>> connections = Optional.ofNullable(this.connectionsRepository.findByOrigin(origin));

        return connections;
    }

    private Optional<List<Connections>> listConnectionsByDescription(String description){

        Optional<List<Connections>> connections = Optional.ofNullable(this.connectionsRepository.findByDescription(description));

        return connections;
    }
    private void insertConnections(Connections connections){

        this.connectionsRepository.save(connections);

    }


    private void updateConnectionsById(Connections connections, Long id){

        Optional<Connections> optional = this.connectionsRepository.findById(id);

        if(optional.isPresent()){
            Connections updatedConnections = optional.get();


            updatedConnections.setDescription(connections.getDescription());
            updatedConnections.setOrigin(connections.getOrigin());
            updatedConnections.setFTP(connections.getFTP());
            updatedConnections.setActive(connections.getActive());
            updatedConnections.setHome(connections.getHome());
            updatedConnections.setLogin(connections.getLogin());
            updatedConnections.setPassword(connections.getPassword());
            updatedConnections.setFTPImpPath(connections.getFTPImpPath());
            updatedConnections.setFTPRetPath(connections.getFTPRetPath());
            updatedConnections.setLocalImpPath(connections.getLocalImpPath());
            updatedConnections.setLocalPedPath(connections.getLocalPedPath());
            updatedConnections.setLocalRetPath(connections.getLocalRetPath());

            this.auditService.insertAudit("asgard", "Atualizado Conexão id: "+ id, "sym", LocalDateTime.now());


        }

    }

}

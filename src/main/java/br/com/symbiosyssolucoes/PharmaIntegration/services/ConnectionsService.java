package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.ConnectionsRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConnectionsService {
    private ConnectionsRepository connectionsRepository;
    private AuditService auditService;


    public ConnectionsService(ConnectionsRepository connectionsRepository, AuditService auditService){
        this.connectionsRepository = connectionsRepository;
        this.auditService = auditService;


    }


    public Optional<List<Connections>> listConnections(){

        Optional<List<Connections>> connections = Optional.of(this.connectionsRepository.findAll());

        return  connections;

    }

    public void listConnectionsById(Long id){

        Optional<Connections> connections = this.connectionsRepository.findById(id);

        System.out.println(connections.toString());
    }


    public Connections insertConnections(Connections connections){

        this.connectionsRepository.save(connections);

        return connections;
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
            updatedConnections.setFtpPedPath(connections.getFtpPedPath());
            updatedConnections.setFtpRetPath(connections.getFtpRetPath());
            updatedConnections.setLocalImpPath(connections.getLocalImpPath());
            updatedConnections.setLocalPedPath(connections.getLocalPedPath());
            updatedConnections.setLocalRetPath(connections.getLocalRetPath());

            this.auditService.insertAudit("asgard", "Atualizado Conexão id: "+ id, "sym", LocalDateTime.now());


        }

    }

}

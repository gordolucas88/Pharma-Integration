package br.com.symbiosyssolucoes.PharmaIntegration.services;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.ConnectionsTypes;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.ConnectionsRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
@Transactional
public class ConnectionsService {
    private ConnectionsRepository connectionsRepository;
    private AuditService auditService;


    public ConnectionsService(ConnectionsRepository connectionsRepository, AuditService auditService){
        this.connectionsRepository = connectionsRepository;
        this.auditService = auditService;


    }

    public void menu(Scanner scanner) throws IOException {
        Boolean isTrue = true;

        while (isTrue) {
            System.out.println("Qual ação você quer executar?");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("1 - Listar Conexões");
            System.out.println("2 - Fechar Conexão");
            System.out.println("3 - Listar Arquivos");
            System.out.println("4 - Subir Arquivos");
            System.out.println("5 - Baixar Arquivos");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.listConnectionsById(scanner.nextLong());
                    break;

                default:
                    isTrue = false;
                    break;

            }
        }
        System.out.println();
    }

    private void listConnectionsById(Long id){

        Optional<Connections> connections = this.connectionsRepository.findById(id);

        System.out.println(connections.toString());
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

package br.com.symbiosyssolucoes.PharmaIntegration.controllers;

import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.services.ConnectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;


@Controller
public class ConnectionController {
    
    @Autowired
    private ConnectionsService connectionsService;
    
    @PostMapping("/connection")
    public ResponseEntity<Connections> insert(@RequestBody Connections request) {



        Connections connections = connectionsService.insertConnections(request);
        connections.setDescription(request.getDescription());
        connections.setPassword("*****");





        return ResponseEntity.created(URI.create("http://localhost:8080/connection/" + connections.getId())).body(connections);
    }
    
}

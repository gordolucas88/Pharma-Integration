package br.com.symbiosyssolucoes.PharmaIntegration.controllers;


import br.com.symbiosyssolucoes.PharmaIntegration.models.PedidoPalm;
import br.com.symbiosyssolucoes.PharmaIntegration.services.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;


@Controller
public class ReturnController {

    @Autowired
    ReturnService returnService;


    @PutMapping("/return")
    public ResponseEntity<PedidoPalm> retornoEMS(@RequestBody PedidoPalm pedidoPalm){


        if(pedidoPalm.getOrigem().equals("EMS")){
            try{
                PedidoPalm retorno = this.returnService.emsReturn(pedidoPalm);
                return ResponseEntity.ok().body(retorno);
            } catch (NoSuchElementException ne) {

                return ResponseEntity.notFound().build();
            }



        }

        return ResponseEntity.notFound().build();

    }
}

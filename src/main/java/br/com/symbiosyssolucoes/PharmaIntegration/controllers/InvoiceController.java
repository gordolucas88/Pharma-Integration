package br.com.symbiosyssolucoes.PharmaIntegration.controllers;

import br.com.symbiosyssolucoes.PharmaIntegration.dto.InvoiceDto;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private FtpService ftpService;
    @Autowired
    private FileService fileService;
    @Autowired
    private ConnectionsService connectionsService;
    @Autowired
    private InvoiceItemService invoiceItemService;



    @GetMapping("/invoice/new")
    public ResponseEntity<String> insertInvoice(Invoice invoice){


        ConnectionsService connectionsService = null;
        Optional<List<Connections>> optionalConnections = this.connectionsService.listConnections();

            if(optionalConnections.isPresent()){
                List<Connections> connectionsList = optionalConnections.get();
                for(int i = 0; i < connectionsList.size(); i++){
                    System.out.println("Entrou no loop de conexao " + i);
                    Connections connections = connectionsList.get(i);

                    try {
                        this.ftpService.downloadAndRemoveFile(connections.getId());
                        List<Invoice> insertedInvoicesList = new ArrayList<Invoice>();
                        String[] filesToImport = this.fileService.listFile(connections.getLocalPedPath());

                        String destinationFolder = connections.getLocalImpPath();

                        if(filesToImport.length > 0 && connections.getOrigin().toString() == "EMS"){
                            String sourceFolder = connections.getLocalPedPath();
                            for(int j = 0; j < filesToImport.length; j++){

                                Invoice emsInvoice = this.fileService.toEms(sourceFolder + filesToImport[j]);
                                emsInvoice.setConnections(connections);



                                Invoice insertedInvoice =  this.invoiceService.insertInvoice(emsInvoice);
                                insertedInvoicesList.add(insertedInvoice);


                                if(insertedInvoice.getId() > 0){
                                    this.fileService.moveFile(sourceFolder + filesToImport[j], destinationFolder + filesToImport[j] );
                                }
                            }

                        }

                        if(filesToImport.length > 0 && connections.getOrigin().toString() == "CONSYS"){
                            String sourceFolder = connections.getLocalPedPath();
                            for(int j = 0; j < filesToImport.length; j++){
                                List<Invoice> invoiceList = this.fileService.toConsys(sourceFolder + filesToImport[j]);
                                List<Invoice> insertedConsysList = new ArrayList<Invoice>();
                                for(int k = 0; k < invoiceList.size(); k++ ){

                                    Invoice consysInvoice = invoiceList.get(k);
                                    consysInvoice.setConnections(connections);

                                    insertedConsysList.add(this.invoiceService.insertInvoice(consysInvoice));


                                    insertedInvoicesList.add(insertedConsysList.get(k));
                                }

                                if(insertedConsysList.size() > 0){
                                    this.fileService.moveFile(sourceFolder + filesToImport[j], destinationFolder + filesToImport[j] );

                                }


                            }

                        }



                    } catch (IOException e){
                        e.printStackTrace();

                    }



                }
                return ResponseEntity.ok().body(new String("Recebido!"));

            } else {
                return ResponseEntity.notFound().build();
            }




        }


    @GetMapping("/invoices")

    public  ResponseEntity<List<InvoiceDto>> invoiceList(){



             List<Invoice> invoiceList = this.invoiceService.listInvoices();
             List<InvoiceDto> invoiceDtoList = new ArrayList<InvoiceDto>();

             invoiceList.forEach(invoice -> {
                 InvoiceDto invoiceDto = new InvoiceDto();

                 invoiceDtoList.add(invoiceDto.toDto(invoice));

             });




        return ResponseEntity.ok().body(invoiceDtoList);

    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> listById(@PathVariable Long id){

        Optional<Invoice> optional = this.invoiceService.listInvoiceById(id);
        if(optional.isPresent()) {
            Invoice invoice = optional.get();
            return ResponseEntity.ok().body(invoice);
        } else {

            return ResponseEntity.notFound().build();
        }




    }
}


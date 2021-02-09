package br.com.symbiosyssolucoes.PharmaIntegration;


import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.Invoice;
import br.com.symbiosyssolucoes.PharmaIntegration.services.ConnectionsService;
import br.com.symbiosyssolucoes.PharmaIntegration.services.FileService;
import br.com.symbiosyssolucoes.PharmaIntegration.services.FtpService;
import br.com.symbiosyssolucoes.PharmaIntegration.services.InvoiceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PharmaIntegrationApplication {

	private FtpService ftpService;
	private ConnectionsService connectionsService;
	private FileService fileService;
	private InvoiceService invoiceService;


	public PharmaIntegrationApplication(FtpService ftpService, ConnectionsService connectionsService, FileService fileService, InvoiceService invoiceService){
		this.ftpService = ftpService;
		this.connectionsService = connectionsService;
		this.fileService = fileService;
		this.invoiceService = invoiceService;

	}

	public static void main(String[] args) {
		SpringApplication.run(PharmaIntegrationApplication.class, args);
	}



}

package br.com.symbiosyssolucoes.PharmaIntegration;


import br.com.symbiosyssolucoes.PharmaIntegration.connections.FtpConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PharmaIntegrationApplication {

	private FtpConnection ftpConnection;

	public PharmaIntegrationApplication(FtpConnection ftpConnection){
		this.ftpConnection = ftpConnection;
	}

	public static void main(String[] args) {
		SpringApplication.run(PharmaIntegrationApplication.class, args);
	}

}

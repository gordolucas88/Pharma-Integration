package br.com.symbiosyssolucoes.PharmaIntegration;


import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.services.ConnectionsService;
import br.com.symbiosyssolucoes.PharmaIntegration.services.FtpConnection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PharmaIntegrationApplication implements CommandLineRunner {

	private FtpConnection ftpConnection;
	private ConnectionsService connectionsService;

	public PharmaIntegrationApplication(FtpConnection ftpConnection, ConnectionsService connectionsService){
		this.ftpConnection = ftpConnection;
		this.connectionsService = connectionsService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PharmaIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while (isTrue) {
			System.out.println("Qual entidade você deseja interagir?");
			System.out.println("0 - Sair");
			System.out.println("1 - FTP");
			System.out.println("2 - Conexões");


			int opcao = scanner.nextInt();

			switch (opcao) {
				case  1:
					this.ftpConnection.menu(scanner);
					break;
				case 2:
					this.connectionsService.menu(scanner);
					break;

				default:
					isTrue = false;
					break;
			}
		}

	}

}

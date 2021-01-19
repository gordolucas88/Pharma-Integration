package br.com.symbiosyssolucoes.PharmaIntegration;

import br.com.symbiosyssolucoes.PharmaIntegration.connections.Ftp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PharmaIntegrationApplication {

	private Ftp ftp;

	public PharmaIntegrationApplication(Ftp ftpClient){
		this.ftp = ftpClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(PharmaIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while (isTrue){

			System.out.println("0 - Sair");
			System.out.println("1 - Listar");
			System.out.println("2 - Upload");
			System.out.println("3 - Download");
			System.out.println("4 - Conectar");

			int opcao = scanner.nextInt();

			switch (opcao){
				case 1:
					this.ftp.listFiles();
					break;
				case 2:
					this.ftpClient.close()
			}

		}
	}
}

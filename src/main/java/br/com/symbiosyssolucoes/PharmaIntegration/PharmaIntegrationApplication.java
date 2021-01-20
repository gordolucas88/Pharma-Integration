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

	//@Override
	public void run(String... args) throws Exception {
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while (isTrue) {
			System.out.println("Qual entidade você deseja interagir?");
			System.out.println("0 - Sair");
			System.out.println("1 - Professor");
			System.out.println("2 - Disciplina");
			System.out.println("3 - Aluno");
			System.out.println("4 - Relatorios");

			int opcao = scanner.nextInt();

			switch (opcao) {
				case  1:
					this.ftpConnection.open();
					break;
//				case 2:
//					this.disciplinaService.menu(scanner);
//					break;
//				case 3:
//					this.alunoService.menu(scanner);
//					break;
//				case 4:
//					this.relatorioService.menu(scanner);
//					break;
				default:
					isTrue = false;
					break;
			}
		}

	}

}

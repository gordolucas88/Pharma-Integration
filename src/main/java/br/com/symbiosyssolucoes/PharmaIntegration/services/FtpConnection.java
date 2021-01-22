package br.com.symbiosyssolucoes.PharmaIntegration.services;


import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.ConnectionsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class FtpConnection {

    private ConnectionsRepository connectionsRepository;
    private FTPClient ftp;




    public void menu(Scanner scanner) throws IOException {
        Boolean isTrue = true;

        while (isTrue) {
            System.out.println("Qual ação você quer executar?");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("1 - Abrir Conexão");
            System.out.println("2 - Fechar Conexão");
            System.out.println("3 - Listar Arquivos");
            System.out.println("4 - Subir Arquivos");
            System.out.println("5 - Baixar Arquivos");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.open();
                    break;
                case 2:
                    this.close();
                    break;
                case 3:
                    this.listFiles("/ret/");
                    break;
                case 4:
                    this.putFileToPath(new File("/test.txt"),"/");
                    break;
                case 5:
                    this.downloadFile("/test.txt","C:\\Cronos\\");
                    break;
                default:
                    isTrue = false;
                    break;

            }
        }
        System.out.println();
    }


    private void open() throws IOException {
        Long id = 1L;
        Optional<Connections> optional = this.connectionsRepository.findById(id);

        if(optional.isPresent()){

            Connections connections = optional.get();
            System.out.println(connections.toString());
            String server = "symbiosyssolucoes.com.br";
            int port = 21;
            String user = "legrand";
            String password = "@nfs32xpt#";
            ftp = new FTPClient();

            ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));

            ftp.connect(server, port);
            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                throw new IOException("Exception in connecting to FTP Server");
            }

            ftp.login(user, password);

        } else {
            System.out.println("Id Passado é invalido");
        }




    }

    private void close() throws IOException {
        ftp.disconnect();
    }

    private Collection<String> listFiles(String path) throws IOException {
        FTPFile[] files = ftp.listFiles(path);

        return Arrays.stream(files)
                .map(FTPFile::getName)
                .collect(Collectors.toList());
    }

    private void putFileToPath(File file, String path) throws IOException {
        ftp.storeFile(path, new FileInputStream(file));
    }

    private void downloadFile(String source, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        ftp.retrieveFile(source, out);
        out.close();
    }
}
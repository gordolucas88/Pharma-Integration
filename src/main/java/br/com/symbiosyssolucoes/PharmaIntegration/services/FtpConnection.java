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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class FtpConnection {

    @Autowired
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
                    this.open(1L);
                    break;
                case 2:
                    this.close();
                    break;
                case 3:
                    this.listFiles(1L);
                    break;
                case 4:
                    this.putFileToPath(1L);
                    break;
                case 5:
                    this.downloadFile(1L);
                    break;
                default:
                    isTrue = false;
                    break;

            }
        }
        System.out.println();
    }


    private void open(Long id) throws IOException {

        Optional<Connections> optional = this.connectionsRepository.findById(id);

        if(optional.isPresent()){

            Connections connections = optional.get();

            String server = connections.getHome();
            int port = 21;
            String user = connections.getLogin();
            String password = connections.getPassword();
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

    private List<String> listFiles(Long id) throws IOException {

        Optional<Connections> optional = this.connectionsRepository.findById(id);
        if(optional.isPresent()) {

            Connections connections = optional.get();

            FTPFile[] files = ftp.listFiles(connections.getFtpPedPath());

            return Arrays.stream(files)
                    .map(FTPFile::getName)
                    .collect(Collectors.toList());
        } else {
          List<String> error = Collections.singletonList("Houve erro ao listar arquivos");
            return error;
        }



    }

    private void putFileToPath(Long id) throws IOException {

        Optional<Connections> optional = this.connectionsRepository.findById(id);

        if(optional.isPresent()) {
            Connections connections = optional.get();

            String path = connections.getFtpRetPath();

            List<String> fileList = this.listFiles(id);

            for (int i = 0; i < fileList.toArray().length; i++ ) {
                File file = new File(fileList.get(i));
                ftp.storeFile(path, new FileInputStream(file));
            }


        } else {
            System.out.println("Deu erro");
        }



    }
//private void downloadFile(String source, String destination) throws IOException {
    private void downloadFile(Long id) throws IOException {

        Optional<Connections> optional = this.connectionsRepository.findById(id);

        if(optional.isPresent()){

            Connections connections = optional.get();

            FileOutputStream out = new FileOutputStream(connections.getLocalPedPath());
            ftp.retrieveFile(connections.getFtpPedPath(), out);
            out.close();

        } else {
            System.out.println("Deu erro");
        }




    }
}
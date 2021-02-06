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
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.net.SocketException;
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
            System.out.println("1 - Subir Arquivos");
            System.out.println("2 - Baixar Arquivos");


            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.putFileToPath(2L);
                    break;
                case 2:
                    this.downloadAndRemoveFile(2L);
                    break;
                default:
                    isTrue = false;
                    break;

            }
        }
        System.out.println();
    }





    private void putFileToPath(Long id) throws SocketException, IOException {

        Optional<Connections> optional = this.connectionsRepository.findById(id);

        if(optional.isPresent()) {
            Connections connections = optional.get();

            FTPClient ftp = new FTPClient();

            ftp.connect( connections.getHome() );

            ftp.login( connections.getLogin(), connections.getPassword() );

            String sourcePath = connections.getLocalRetPath();
            String destinationPath = connections.getFtpRetPath();

            String[] fileList = new File(sourcePath).list();

            for (int i = 0; i < fileList.length; i++ ) {

                System.out.println(sourcePath + fileList[i]);
               FileInputStream fileToSend = new FileInputStream(sourcePath + fileList[i]);

               if(ftp.storeFile(destinationPath + fileList[i], fileToSend)){
                   System.out.println("Arquivo armazenado com sucesso!");
                   fileToSend.close();
                   File fileToDelete = new File(sourcePath + fileList[i]);
                   if(fileToDelete.delete() == true){
                       System.out.println(fileToDelete.getName() + " Excluido");
                   }
               } else {
                   System.out.println ("Erro ao armazenar o arquivo.");
               }


            }

            ftp.disconnect();
        } else {
            System.out.println("Deu erro");
        }



    }




    private void downloadAndRemoveFile(Long id) throws SocketException, IOException {{
        Optional<Connections> optional = this.connectionsRepository.findById(id);

        if( optional.isPresent()){
            Connections connections = optional.get();

            FTPClient ftp = new FTPClient();

            ftp.connect( connections.getHome() );

            ftp.login( connections.getLogin(), connections.getPassword() );

            ftp.changeWorkingDirectory (connections.getFtpPedPath());
            String[] arq = ftp.listNames();

            for(int i = 0; i < arq.length; i++){
                System.out.println(arq[i]);
                System.out.println( connections.getLocalPedPath() + arq[i]);
                FileOutputStream fos =

                        new FileOutputStream( connections.getLocalPedPath() + arq[i] );

                if (ftp.retrieveFile( arq[i], fos )) {
                    fos.close();
                    System.out.println("Download efetuado com sucesso!");
                    ftp.deleteFile(arq[i]);
                }
                else {

                    System.out.println("Erro ao efetuar download do arquivo.");
                }
            }
            ftp.disconnect();


        }





    }
    }
}

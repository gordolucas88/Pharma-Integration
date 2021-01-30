package br.com.symbiosyssolucoes.PharmaIntegration.services;


import br.com.symbiosyssolucoes.PharmaIntegration.entity.Connections;
import br.com.symbiosyssolucoes.PharmaIntegration.entity.FileTypes;
import br.com.symbiosyssolucoes.PharmaIntegration.repository.ConnectionsRepository;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

@Data

@Service
public class Files {



    public void menu(Scanner scanner) throws IOException {
        Boolean isTrue = true;

        while (isTrue) {
            System.out.println("Qual ação você quer executar?");
            System.out.println("0 - Voltar ao menu anterior");
            System.out.println("1 - Listar arquivos");
            System.out.println("2 - Mover Arquivo");
//            System.out.println("3 - Listar Arquivos");
//            System.out.println("4 - Subir Arquivos");
//            System.out.println("5 - Baixar Arquivos");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.listFile("C:\\Symbiosys\\ped\\");
                    break;
                case 2:
                    this.moveFile("C:\\Symbiosys\\ped\\teste.txt","C:\\Symbiosys\\imp\\teste.txt");
                    break;
//                case 3:
//                    this.listFiles(1L);
//                    break;
//                case 4:
//                    this.putFileToPath(1L);
//                    break;
//                case 5:
//                    this.downloadFile(1L);
//                    break;
                default:
                    isTrue = false;
                    break;

            }
        }
        System.out.println();
    }

    public String[] listFile(String path) {


        File folder = new File(path);

        String[] files = folder.list();

        for(int i = 0; i < files.length; i++ ){
            System.out.println(files[i]);
        }




        return files;
    }

    public void moveFile(String srcFile, String destPath) {

        File source = new File(srcFile);
        File destination = new File(destPath);
        source.renameTo(destination);


    }

    public String mkDir(String dirName) {

        File folder = new File(dirName);
        if (folder.exists() != true){
            folder.mkdir();
        }
        return  folder.getAbsolutePath();
    }





}

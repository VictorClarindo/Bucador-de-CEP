package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String sair = "";
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um CEP para consultar (Digite 0 para sair): ");
        String cepBuscado = leitor.nextLine();


        ConsultaCep consultaCep = new ConsultaCep();
        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cepBuscado);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }
    }
}
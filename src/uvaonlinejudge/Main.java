package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int qtdRequisitos = Integer.parseInt(vet[0]);
        int qtdPropostas = Integer.parseInt(vet[1]);
        int cont = 1;
        while (qtdPropostas != 0 && qtdRequisitos != 0) {
            for (int i = 0; i < qtdRequisitos; i++) {
                entrada.readLine();
            }
            String nomeMelhor = "";
            int maxReq = 0;
            double minValor = Integer.MAX_VALUE;
            for (int i = 0; i < qtdPropostas; i++) {
                String nome = entrada.readLine();
                linha = entrada.readLine();
                vet = linha.split(" ");
                double valor = Double.parseDouble(vet[0]);
                int reqs = Integer.parseInt(vet[1]);
                for (int j = 0; j < reqs; j++) {
                    entrada.readLine();
                }
                if (reqs > maxReq || (reqs == maxReq && valor < minValor)) {
                    maxReq = reqs;
                    nomeMelhor = nome;
                    minValor = valor;
                }
            }
            saida.write("RFP #" + cont);
            saida.newLine();
            saida.write(nomeMelhor);
            saida.newLine();
            linha = entrada.readLine();
            vet = linha.split(" ");
            qtdRequisitos = Integer.parseInt(vet[0]);
            qtdPropostas = Integer.parseInt(vet[1]);
            if (qtdRequisitos != 0) {
                saida.newLine();
            }
            cont++;
        }
        saida.flush();
    }
}

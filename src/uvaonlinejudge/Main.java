package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        int qtdTeste = Integer.parseInt(linha);
        for (int i = 0; i < qtdTeste; i++) {
            linha = entrada.readLine();
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            int maior = -1;
            int menor = 99999999;
            for (int j = 0; j < vet.length; j++) {
                int tmp = Integer.parseInt(vet[j]);
                if(tmp > maior) {
                    maior = tmp;
                } 
                if (tmp < menor) menor = tmp;
            }
            int total = 2 * (maior - menor);
            saida.write(total + "\n");
        }
        saida.flush();
    }
}

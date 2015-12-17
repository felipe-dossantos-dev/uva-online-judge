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
        int qtdTeste = Integer.parseInt(linha);
        //12157
        for (int i = 0; i < qtdTeste; i++) {
            linha = entrada.readLine();
            int qtdLigacao = Integer.parseInt(linha);
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            int mile = 0;
            int juice = 0;
            for (String s : vet) {
                int tmp = Integer.parseInt(s);
                mile += (1 + (tmp - 1) / 29) * 10;
                juice += (1 + (tmp - 1) / 59) * 15;
            }

            saida.write("Case " + (i + 1) + ": ");
            if (mile > juice) {
                saida.write("Juice " + juice);
            } else if (juice > mile) {
                saida.write("Mile " + mile);
            } else {
                saida.write("Mile Juice " + mile);
            }
            saida.newLine();
        }
        saida.flush();
    }
}

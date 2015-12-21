package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        char[] bytes = new char[100];
        for (int i = 0; i < qtdTestes; i++) {
            Arrays.fill(bytes, (char) 0);
            linha = entrada.readLine();
            int pos = 0;
            for (char c : linha.toCharArray()) {
                if (c == '+') {
                    bytes[pos]++;
                } else if (c == '-') {
                    bytes[pos]--;
                } else if (c == '<') {
                    pos--;
                    pos = (pos + 100) % 100;
                } else if (c == '>') {
                    pos++;
                    pos = (pos + 100) % 100;
                } 
            }
            saida.write("Case " + (i + 1) + ":");
            for (int j = 0; j < 100; j++) {
                saida.write(' ');
                saida.write(bytes[j]);
            }
            saida.newLine();
        }
        saida.flush();
    }
}

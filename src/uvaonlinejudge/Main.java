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
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));C:\\Users\\felipe.santos\\Documents\\
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            int matriz[][] = new int[5][5];
            int notNulls = Integer.parseInt(linha);
            for (int j = 0; j < notNulls; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                int row = Integer.parseInt(vet[0]);
                int col = Integer.parseInt(vet[1]);
                int value = Integer.parseInt(vet[2]);
                matriz[row][col] = value;
            }
            for (int j = 0; j < 5; j++) {
                System.out.println(Arrays.toString(matriz[j]));
            }
            System.out.println("");
        }
        saida.flush();
    }
}

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
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int rows = Integer.parseInt(vet[0]);
        int cols = Integer.parseInt(vet[1]);
        while (rows != 0 || cols != 0) {
            int qtd;
            if (rows == 0 || cols == 0) {
                qtd = 0;
            } else if (rows == 1 || cols == 1) {
                qtd = rows * cols;
            } else {
                if (rows == 2 || cols == 2) {
                    qtd = (rows * cols) / 2;
                    qtd = qtd + qtd % 4 == 1 ? 2 : 0 
                            + qtd % 4 == 2 ? 4 : 0 
                            + qtd % 4 == 3 ? 2 : 0;
                } else {
                    qtd = (rows * cols + 1) / 2;
                }
            }
            saida.write(String.format("%d knights may be placed on a %d row %d column board.\n", qtd, rows, cols));
            linha = entrada.readLine();
            vet = linha.split(" ");
            rows = Integer.parseInt(vet[0]);
            cols = Integer.parseInt(vet[1]);
        }
        saida.flush();
    }
}

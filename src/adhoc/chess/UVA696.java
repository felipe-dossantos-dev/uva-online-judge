package adhoc.chess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA696 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
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
            } else if (rows == 2 || cols == 2) {
                int max = Math.max(rows, cols);
                int min = Math.min(rows, cols);
                if (max <= 3) {
                    qtd = 4;
                } else {
                    int tmp = max / 4;
                    int rem = max % 4;
                    qtd = tmp * 4 + Math.min(rem, 2) * 2;
                }
            } else {
                qtd = (rows * cols + 1) / 2;
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

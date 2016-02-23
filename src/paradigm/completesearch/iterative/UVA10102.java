package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10102 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));

        String linha = entrada.readLine();
        while (linha != null) {
            int size = Integer.parseInt(linha);
            char matriz[][] = new char[size][size];
            for (int i = 0; i < size; i++) {
                matriz[i] = entrada.readLine().trim().toCharArray();
            }
            int menor = Integer.MIN_VALUE;
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (matriz[row][col] == '1') {
                        int atual = Integer.MAX_VALUE;
                        for (int baixo = 0; baixo < size; baixo++) {
                            for (int dir = 0; dir < size; dir++) {
                                if (matriz[baixo][dir] == '3') {
                                    int manhattanDistance = Math.abs(row - baixo) + Math.abs(col - dir);
                                    atual = Math.min(atual, manhattanDistance);
                                }
                            }
                        }
                        menor = Math.max(atual, menor);
                    }
                }
            }
            saida.write(menor + "\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

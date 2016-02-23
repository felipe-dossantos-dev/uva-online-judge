package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class UVA735 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));

        String linha = entrada.readLine();
        int score = Integer.parseInt(linha);

        Set<Integer> values = new HashSet<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 20; j++) {
                values.add(i * j);
            }
        }
        values.add(50);
        boolean combinacoes[][][] = new boolean[65][65][65];

        while (score > 0) {
            int perm = 0;
            int comb = 0;
            for (int i = 0; i < 65; i++) {
                for (int j = 0; j < 65; j++) {
                    Arrays.fill(combinacoes[i][j], false);
                }
            }
            for (Integer i : values) {
                for (Integer j : values) {
                    for (Integer k : values) {
                        if (i + j + k == score) {
                            perm++;
                            if (!combinacoes[i][j][k]) {
                                comb++;
                                combinacoes[i][j][k] = true;
                                combinacoes[i][k][j] = true;
                                combinacoes[j][i][k] = true;
                                combinacoes[j][k][i] = true;
                                combinacoes[k][i][j] = true;
                                combinacoes[k][j][i] = true;
                            }
                        }
                    }
                }
            }
            if (perm == 0) {
                saida.write(String.format("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", score));
            } else {
                saida.write(String.format("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", score, comb));
                saida.write(String.format("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", score, perm));
            }
            saida.write("**********************************************************************\n");
            linha = entrada.readLine();
            score = Integer.parseInt(linha);
        }
        saida.write("END OF OUTPUT\n");
        saida.flush();
    }
}

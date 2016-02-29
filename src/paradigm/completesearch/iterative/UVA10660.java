package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10660 {

    public static int MATRIX_MAX = 25;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            int solution[] = new int[5];
            linha = entrada.readLine();
            int matriz[] = new int[MATRIX_MAX];
            int notNulls = Integer.parseInt(linha);
            for (int j = 0; j < notNulls; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                int row = Integer.parseInt(vet[0]);
                int col = Integer.parseInt(vet[1]);
                int value = Integer.parseInt(vet[2]);
                matriz[5 * row + col] = value;
            }
            int minDist = Integer.MAX_VALUE;
            for (int a = 0; a < MATRIX_MAX - 4; a++) {
                for (int b = a + 1; b < MATRIX_MAX - 3; b++) {
                    for (int c = b + 1; c < MATRIX_MAX - 2; c++) {
                        for (int d = c + 1; d < MATRIX_MAX - 1; d++) {
                            for (int e = d + 1; e < MATRIX_MAX; e++) {
                                int offices[] = {a, b, c, d, e};
                                int somaDist = 0;
                                for (int j = 0; j < MATRIX_MAX; j++) {
                                    int dist = manhattanDistance(j, offices[0]);
                                    for (int k = 1; k < 5; k++) {
                                        int tmp = manhattanDistance(j, offices[k]);
                                        if (tmp < dist) {
                                            dist = tmp;
                                        }
                                    }
                                    dist *= matriz[j];
                                    somaDist += dist;
                                }

                                if (somaDist < minDist) {
                                    minDist = somaDist;
                                    solution = offices;
                                }
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < solution.length; j++) {
                int t = solution[j];
                saida.write(t + "");
                if (j + 1 != solution.length) {
                    saida.write(" ");
                }
            }
            saida.write("\n");
        }
        saida.flush();
    }

    public static int manhattanDistance(int pos1, int pos2) {
        int x1 = pos1 / 5;
        int x2 = pos2 / 5;
        int y1 = pos1 % 5;
        int y2 = pos2 % 5;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

package adhoc.others.harder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10443 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine().trim();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            String vet[] = linha.trim().split("\\s+");

            int lins = Integer.parseInt(vet[0]);
            int cols = Integer.parseInt(vet[1]);
            int n = Integer.parseInt(vet[2]);
            if (lins != 0 || cols != 0) {
                char grid[][] = new char[lins][cols];
                for (int j = 0; j < lins; j++) {
                    linha = entrada.readLine();
                    grid[j] = linha.toCharArray();
                }
                for (int j = 0; j < n; j++) {
                    char novoGrid[][] = new char[lins][cols];
                    for (int k = 0; k < lins; k++) {
                        for (int l = 0; l < cols; l++) {
                            novoGrid[k][l] = ganha(grid, k, l);
                        }
                    }
                    grid = novoGrid;
                }
                for (int j = 0; j < lins; j++) {
                    for (int k = 0; k < cols; k++) {
                        saida.write(grid[j][k]);
                    }
                    saida.write("\n");
                }
                if (i != qtdTestes - 1) {
                    saida.write("\n");
                }
            } else {
                linha = entrada.readLine();
            }
        }
        saida.flush();
    }

    public static char ganha(char[][] grid, int i, int j) {
        boolean troca = false;
        char centro = grid[i][j];
        if (i - 1 >= 0) {
            char outra = grid[i - 1][j];
            if ((centro == 'P' && outra == 'S')
                    || (centro == 'R' && outra == 'P')
                    || (centro == 'S' && outra == 'R')) {
                troca = true;
            }
        }
        if (i + 1 < grid.length) {
            char outra = grid[i + 1][j];
            if ((centro == 'P' && outra == 'S')
                    || (centro == 'R' && outra == 'P')
                    || (centro == 'S' && outra == 'R')) {
                troca = true;
            }
        }
        if (j - 1 >= 0) {
            char outra = grid[i][j - 1];
            if ((centro == 'P' && outra == 'S')
                    || (centro == 'R' && outra == 'P')
                    || (centro == 'S' && outra == 'R')) {
                troca = true;
            }
        }
        if (j + 1 < grid[0].length) {
            char outra = grid[i][j + 1];
            if ((centro == 'P' && outra == 'S')
                    || (centro == 'R' && outra == 'P')
                    || (centro == 'S' && outra == 'R')) {
                troca = true;
            }
        }
        if (troca && centro == 'P') {
            return 'S';
        } else if (troca && centro == 'R') {
            return 'P';
        } else if (troca && centro == 'S') {
            return 'R';
        } else {
            return centro;
        }
    }
}

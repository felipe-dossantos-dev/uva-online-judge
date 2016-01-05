package adhoc.others.harder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Scanner;

public class UVA10813 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        int qtdTestes = entrada.nextInt();
        for (int i = 0; i < qtdTestes; i++) {
            int cartela[][] = new int[5][5];
            cartela[2][2] = -1;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (cartela[j][k] != -1) {
                        cartela[j][k] = entrada.nextInt();
                    }
                }
            }
            int cont = 0;
            boolean terminar = false;
            for (int j = 0; j < 75; j++) {
                if (!terminar) {
                    cont++;
                }
                int atual = entrada.nextInt();
                int col = coluna(atual);
                for (int k = 0; k < 5; k++) {
                    if (cartela[k][col] == atual) {
                        cartela[k][col] = -1;
                        if (ganhou(cartela, k, col)) {
                            terminar = true;
                        }
                    }
                }
            }
            saida.write(String.format("BINGO after %d numbers announced\n", cont));
        }
        saida.flush();
    }

    public static boolean ganhou(int[][] cartela, int lin, int col) {
        int cont = 0;
        //coluna
        for (int i = 0; i < 5; i++) {
            if (cartela[i][col] == -1) {
                cont++;
            }
        }
        if (cont == 5) {
            return true;
        }
        //lin
        cont = 0;
        for (int i = 0; i < 5; i++) {
            if (cartela[lin][i] == -1) {
                cont++;
            }
        }
        if (cont == 5) {
            return true;
        }
        //diag
        if (cartela[0][0] == -1
                && cartela[1][1] == -1
                && cartela[3][3] == -1
                && cartela[4][4] == -1) {
            return true;
        }
        //diag
        if (cartela[0][4] == -1
                && cartela[1][3] == -1
                && cartela[3][1] == -1
                && cartela[4][0] == -1) {
            return true;
        }
        return false;
    }

    public static int coluna(int atual) {
        if (atual <= 15) {
            return 0;
        }
        if (atual <= 30) {
            return 1;
        }
        if (atual <= 45) {
            return 2;
        }
        if (atual <= 60) {
            return 3;
        }
        return 4;
    }
}

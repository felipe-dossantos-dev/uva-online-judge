package adhoc.chess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA255 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            String vet[] = linha.split(" ");
            int king = Integer.parseInt(vet[0]);
            int queen = Integer.parseInt(vet[1]);
            int move = Integer.parseInt(vet[2]);
            if (isStateLegal(king, queen)) {
                if (isMovelLegal(king, queen, move)) {
                    if (isAllowed(king, move)) {
                        if (isStop(king, move)) {
                            saida.write("Stop");
                        } else {
                            saida.write("Continue");
                        }
                    } else {
                        saida.write("Move not allowed");
                    }
                } else {
                    saida.write("Illegal move");
                }
            } else {
                saida.write("Illegal state");
            }
            linha = entrada.readLine();
            saida.write("\n");
        }
        saida.flush();
    }

    public static boolean isStateLegal(int king, int queen) {
        return king != queen;
    }

    private static boolean isMovelLegal(int king, int queen, int move) {
        if (queen == move) {
            return false;
        }
        //horizontal
        int esq = queen - (queen % 8);
        int dir = queen + 7 - queen % 8;
        if (move >= esq && move <= dir) {
            if (queen < move) {
                esq = queen;
                dir = move;
            } else {
                esq = move;
                dir = queen;
            }
            for (int i = esq; i <= dir; i++) {
                if (i == king) {
                    return false;
                }
            }
            return true;
        }
        //vertical
        if (queen % 8 == move % 8) {
            if (queen < move) {
                int aux = move;
                move = queen;
                queen = aux;
            }
            for (int i = move; i <= queen; i += 8) {
                if (i == king) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isAllowed(int king, int move) {
        boolean allowed = true;
        if (king / 8 == (king - 1) / 8 && king - 1 == move) {
            allowed = false;
        }
        if (king / 8 == (king + 1) / 8 && king + 1 == move) {
            allowed = false;
        }
        //coluna
        if (king + 8 < 64 && king + 8 == move) {
            allowed = false;
        }
        if (king - 8 >= 0 && king - 8 == move) {
            allowed = false;
        }
        return allowed;
    }

    private static boolean isStop(int king, int move) {
        return (king == 0 && move == 9)
                || (king == 7 && move == 14)
                || (king == 63 && move == 54)
                || (king == 56 && move == 49);
    }
}

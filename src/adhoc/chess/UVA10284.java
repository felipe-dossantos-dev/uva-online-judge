package adhoc.chess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10284 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            char game[][] = new char[8][8];
            String vet[] = linha.split("/");
            //leitura
            int vazios = 0;
            for (int i = 0; i < vet.length; i++) {
                String fen = vet[i];
                if (fen.isEmpty()) {
                    vazios++;
                }
                int col = 0;
                for (int j = 0; j < fen.length(); j++) {
                    char pos = fen.charAt(j);
                    //vazios
                    if (pos >= '1' && pos <= '8') {
                        int qtdVazio = pos - '0';
                        for (int k = 0; k < qtdVazio; k++) {
                            game[i - vazios][col] = '.';
                            col++;
                        }
                    } else {
                        game[i - vazios][col] = pos;
                        col++;
                    }
                }
            }
            //trocar os . (espaços vazios) por espaços atacados (*) 
            for (int i = 0; i < game.length; i++) {
                char[] game1 = game[i];
                for (int j = 0; j < game1.length; j++) {
                    char h = game1[j];
                    //lower black - start top
                    //upper white - start bottom
                    if (h == 'p') {
                        //System.out.println("peao black");
                        if (i + 1 < 8 && j - 1 >= 0 && game[i + 1][j - 1] == '.') {
                            game[i + 1][j - 1] = '*';
                        }
                        if (i + 1 < 8 && j + 1 < 8 && game[i + 1][j + 1] == '.') {
                            game[i + 1][j + 1] = '*';
                        }
                    } else if (h == 'P') {
                        //System.out.println("peao white");
                        if (i - 1 >= 0 && j - 1 >= 0 && game[i - 1][j - 1] == '.') {
                            game[i - 1][j - 1] = '*';
                        }
                        if (i - 1 >= 0 && j + 1 < 8 && game[i - 1][j + 1] == '.') {
                            game[i - 1][j + 1] = '*';
                        }
                    } else if (h == 'k' || h == 'K') {
                        //System.out.println("reis");
                        //top
                        if (i - 1 >= 0) {
                            if (game[i - 1][j] == '.') {
                                game[i - 1][j] = '*';
                            }
                            if (j - 1 >= 0 && game[i - 1][j - 1] == '.') {
                                game[i - 1][j - 1] = '*';
                            }
                            if (j + 1 <= 8 && game[i - 1][j + 1] == '.') {
                                game[i - 1][j + 1] = '*';
                            }
                        }
                        //centro
                        if (j - 1 >= 0 && game[i][j - 1] == '.') {
                            game[i][j - 1] = '*';
                        }
                        if (j + 1 <= 8 && game[i][j + 1] == '.') {
                            game[i][j + 1] = '*';
                        }
                        //baixo
                        if (i + 1 < 8) {
                            if (game[i + 1][j] == '.') {
                                game[i + 1][j] = '*';
                            }
                            if (j - 1 >= 0 && game[i + 1][j - 1] == '.') {
                                game[i + 1][j - 1] = '*';
                            }
                            if (j + 1 <= 8 && game[i + 1][j + 1] == '.') {
                                game[i + 1][j + 1] = '*';
                            }
                        }
                    } else if (h == 'R' || h == 'r') {
                        //esq
                        for (int k = j - 1; k >= 0 && (game[i][k] == '.' || game[i][k] == '*'); k--) {
                            game[i][k] = '*';
                        }
                        //dir
                        for (int k = j + 1; k < 8 && (game[i][k] == '.' || game[i][k] == '*'); k++) {
                            game[i][k] = '*';
                        }
                        //top
                        for (int k = i - 1; k >= 0 && (game[k][j] == '.' || game[k][j] == '*'); k--) {
                            game[k][j] = '*';
                        }
                        //bot
                        for (int k = i + 1; k < 8 && (game[k][j] == '.' || game[k][j] == '*'); k++) {
                            game[k][j] = '*';
                        }
                    } else if (h == 'b' || h == 'B') {
                        //esq top
                        for (int k = -1;; k--) {
                            if (i + k >= 0 && j + k >= 0 && (game[i + k][j + k] == '.' || game[i + k][j + k] == '*')) {
                                game[i + k][j + k] = '*';
                            } else {
                                break;
                            }
                        }
                        //dir bot
                        for (int k = 1;; k++) {
                            if (i + k < 8 && j + k < 8 && (game[i + k][j + k] == '.' || game[i + k][j + k] == '*')) {
                                game[i + k][j + k] = '*';
                            } else {
                                break;
                            }
                        }
                        //dir top
                        for (int k = 1;; k++) {
                            if (i - k >= 0 && j + k < 8 && (game[i - k][j + k] == '.' || game[i - k][j + k] == '*')) {
                                game[i - k][j + k] = '*';
                            } else {
                                break;
                            }
                        }
                        //esq bot
                        for (int k = 1;; k++) {
                            if (i + k < 8 && j - k >= 0 && (game[i + k][j - k] == '.' || game[i + k][j - k] == '*')) {
                                game[i + k][j - k] = '*';
                            } else {
                                break;
                            }
                        }
                    } else if (h == 'Q' || h == 'q') {
                        //esq top
                        for (int k = -1;; k--) {
                            if (i + k >= 0 && j + k >= 0 && (game[i + k][j + k] == '.' || game[i + k][j + k] == '*')) {
                                game[i + k][j + k] = '*';
                            } else {
                                break;
                            }
                        }
                        //dir bot
                        for (int k = 1;; k++) {
                            if (i + k < 8 && j + k < 8 && (game[i + k][j + k] == '.' || game[i + k][j + k] == '*')) {
                                game[i + k][j + k] = '*';
                            } else {
                                break;
                            }
                        }
                        //dir top
                        for (int k = 1;; k++) {
                            if (i - k >= 0 && j + k < 8 && (game[i - k][j + k] == '.' || game[i - k][j + k] == '*')) {
                                game[i - k][j + k] = '*';
                            } else {
                                break;
                            }
                        }
                        //esq bot
                        for (int k = 1;; k++) {
                            if (i + k < 8 && j - k >= 0 && (game[i + k][j - k] == '.' || game[i + k][j - k] == '*')) {
                                game[i + k][j - k] = '*';
                            } else {
                                break;
                            }
                        }
                        //esq
                        for (int k = j - 1; k >= 0 && (game[i][k] == '.' || game[i][k] == '*'); k--) {
                            game[i][k] = '*';
                        }
                        //dir
                        for (int k = j + 1; k < 8 && (game[i][k] == '.' || game[i][k] == '*'); k++) {
                            game[i][k] = '*';
                        }
                        //top
                        for (int k = i - 1; k >= 0 && (game[k][j] == '.' || game[k][j] == '*'); k--) {
                            game[k][j] = '*';
                        }
                        //bot
                        for (int k = i + 1; k < 8 && (game[k][j] == '.' || game[k][j] == '*'); k++) {
                            game[k][j] = '*';
                        }
                    } else if (h == 'n' || h == 'N') {
                        if (i - 2 >= 0) {
                            if (j - 1 >= 0 && game[i - 2][j - 1] == '.') {
                                game[i - 2][j - 1] = '*';
                            }
                            if (j + 1 < 8 && game[i - 2][j + 1] == '.') {
                                game[i - 2][j + 1] = '*';
                            }
                        }
                        if (i - 1 >= 0) {
                            if (j - 2 >= 0 && game[i - 1][j - 2] == '.') {
                                game[i - 1][j - 2] = '*';
                            }
                            if (j + 2 < 8 && game[i - 1][j + 2] == '.') {
                                game[i - 1][j + 2] = '*';
                            }
                        }
                        if (i + 1 < 8) {
                            if (j - 2 >= 0 && game[i + 1][j - 2] == '.') {
                                game[i + 1][j - 2] = '*';
                            }
                            if (j + 2 < 8 && game[i + 1][j + 2] == '.') {
                                game[i + 1][j + 2] = '*';
                            }
                        }
                        if (i + 2 < 8) {
                            if (j - 1 >= 0 && game[i + 2][j - 1] == '.') {
                                game[i + 2][j - 1] = '*';
                            }
                            if (j + 1 < 8 && game[i + 2][j + 1] == '.') {
                                game[i + 2][j + 1] = '*';
                            }
                        }
                    }
                }
            }
            int cont = 0;
            //contar .
            for (int i = 0; i < game.length; i++) {
                char[] game1 = game[i];
                for (int j = 0; j < game1.length; j++) {
                    char h = game1[j];
                    if (h == '.') {
                        cont++;
                    }
                }
            }
            saida.write(cont + "\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

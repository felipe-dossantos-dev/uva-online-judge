package adhoc.others.harder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA584 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (!linha.equals("Game Over")) {
            String vet[] = linha.trim().split("\\s+");
            int jogadas[] = new int[vet.length];
            int ant = 0;
            for (int i = 0; i < vet.length; i++) {
                String jogada = vet[i];
                if (jogada.equals("X")) {
                    jogadas[i] = 10;
                } else if (jogada.equals("/")) {
                    jogadas[i] = (10 - ant);
                } else {
                    int tmp = Integer.parseInt(jogada);
                    jogadas[i] = tmp;
                    ant = tmp;
                }
            }
            int turn = 0;
            int pos = 0;
            int pontos = 0;
            while (turn < 10) {
                int roll = jogadas[pos];
                pontos += roll;
                if (turn < 9) {
                    if (roll == 10) {
                        if (pos + 1 < jogadas.length) {
                            pontos += jogadas[pos + 1];
                        }
                        if (pos + 2 < jogadas.length) {
                            pontos += jogadas[pos + 2];
                        }
                    } else {
                        ant = roll;
                        pos++;
                        roll = jogadas[pos];
                        pontos += roll;
                        if (roll + ant == 10 && pos + 1 < jogadas.length) {
                            pontos += jogadas[pos + 1];
                        }
                    }
                } else {
                    if (roll == 10) {
                        pos++;
                        roll = jogadas[pos];
                        pontos += roll;
                        pos++;
                        roll = jogadas[pos];
                        pontos += roll;
                    } else {
                        ant = roll;
                        pos++;
                        roll = jogadas[pos];
                        pontos += roll;
                        if (ant + roll == 10) {
                            pos++;
                            roll = jogadas[pos];
                            pontos += roll;
                        }
                    }
                }
                turn++;
                pos++;
            }
            saida.write(pontos + "\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

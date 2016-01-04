package adhoc.others.easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class UVA11459 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        int qtdTestes = entrada.nextInt();
        int grid[] = new int[105];
        Arrays.fill(grid, -1);
        for (int i = 0; i < qtdTestes; i++) {
            int numPlayers = entrada.nextInt();
            int numSnakes = entrada.nextInt();
            int numDiceRolls = entrada.nextInt();

            int posPlayers[] = new int[numPlayers];
            Arrays.fill(posPlayers, 1);
            //leitura das snakes and ladders
            for (int j = 0; j < numSnakes; j++) {
                int ini = entrada.nextInt();
                int fim = entrada.nextInt();
                grid[ini] = fim;
            }
            int player = 0;
            boolean finish = false;
            for (int j = 0; j < numDiceRolls; j++) {
                int roll = entrada.nextInt();
                if (!finish) {
                    posPlayers[player] += roll;
                    if (grid[posPlayers[player]] != -1) {
                        posPlayers[player] = grid[posPlayers[player]];
                    }
                    if (posPlayers[player] >= 100) {
                        posPlayers[player] = 100;
                        finish = true;
                    }
                }
                player++;
                player = player % numPlayers;
            }
            for (int j = 0; j < numPlayers; j++) {
                saida.write(String.format("Position of player %d is %d.\n", j + 1, posPlayers[j]));
            }
            Arrays.fill(grid, -1);
        }
        saida.flush();
    }
}

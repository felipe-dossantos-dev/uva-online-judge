package adhoc.game.card;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA462 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            String vet[] = linha.split(" ");
            int handValue = 0;
            int suitValue = 0;
            int[] suits = new int[4]; //S, H, D, C
            List<String> aces = new ArrayList<>();
            List<String> kings = new ArrayList<>();
            List<String> queens = new ArrayList<>();
            List<String> jacks = new ArrayList<>();
            for (String card : vet) {
                if (card.charAt(0) == 'A') {
                    handValue += 4;
                    aces.add(card);
                } else if (card.charAt(0) == 'K') {
                    handValue += 3;
                    kings.add(card);
                } else if (card.charAt(0) == 'Q') {
                    handValue += 2;
                    queens.add(card);
                } else if (card.charAt(0) == 'J') {
                    handValue += 1;
                    jacks.add(card);
                }
                if (card.charAt(1) == 'S') {
                    suits[0]++;
                } else if (card.charAt(1) == 'H') {
                    suits[1]++;
                } else if (card.charAt(1) == 'D') {
                    suits[2]++;
                } else if (card.charAt(1) == 'C') {
                    suits[3]++;
                }
            }
            int posBiggerSuit = - 1;
            int valueBiggerSuit = -1;
            for (int i = 0; i < 4; i++) {
                int suit = suits[i];
                if (suit == 2) {
                    suitValue++;
                } else if (suit == 1 || suit == 0) {
                    suitValue += 2;
                }
                if (suit > valueBiggerSuit) {
                    valueBiggerSuit = suit;
                    posBiggerSuit = i;
                }
            }
            for (String king : kings) {
                int pos = -1;
                if (king.charAt(1) == 'S') {
                    pos = 0;
                } else if (king.charAt(1) == 'H') {
                    pos = 1;
                } else if (king.charAt(1) == 'D') {
                    pos = 2;
                } else if (king.charAt(1) == 'C') {
                    pos = 3;
                }
                // - 1 pq não pode contar a própria carta
                if (pos != - 1 && suits[pos] - 1 == 0) {
                    handValue--;
                }
            }
            for (String queen : queens) {
                int pos = -1;
                if (queen.charAt(1) == 'S') {
                    pos = 0;
                } else if (queen.charAt(1) == 'H') {
                    pos = 1;
                } else if (queen.charAt(1) == 'D') {
                    pos = 2;
                } else if (queen.charAt(1) == 'C') {
                    pos = 3;
                }
                // - 1 pq não pode contar a própria carta
                if (pos != - 1 && suits[pos] - 1 <= 1) {
                    handValue--;
                }
            }
            for (String jack : jacks) {
                int pos = -1;
                if (jack.charAt(1) == 'S') {
                    pos = 0;
                } else if (jack.charAt(1) == 'H') {
                    pos = 1;
                } else if (jack.charAt(1) == 'D') {
                    pos = 2;
                } else if (jack.charAt(1) == 'C') {
                    pos = 3;
                }
                // - 1 pq não pode contar a própria carta
                if (pos != - 1 && suits[pos] - 1 <= 2) {
                    handValue--;
                }
            }

            boolean stopped[] = new boolean[4];

            for (String ace : aces) {
                if (ace.charAt(1) == 'S') {
                    stopped[0] = true;
                } else if (ace.charAt(1) == 'H') {
                    stopped[1] = true;
                } else if (ace.charAt(1) == 'D') {
                    stopped[2] = true;
                } else if (ace.charAt(1) == 'C') {
                    stopped[3] = true;
                }
            }
            for (String king : kings) {
                if (king.charAt(1) == 'S' && suits[0] - 1 >= 1) {
                    stopped[0] = true;
                } else if (king.charAt(1) == 'H' && suits[1] - 1 >= 1) {
                    stopped[1] = true;
                } else if (king.charAt(1) == 'D' && suits[2] - 1 >= 1) {
                    stopped[2] = true;
                } else if (king.charAt(1) == 'C' && suits[3] - 1 >= 1) {
                    stopped[3] = true;
                }
            }
            for (String queen : queens) {
                if (queen.charAt(1) == 'S' && suits[0] - 1 >= 2) {
                    stopped[0] = true;
                } else if (queen.charAt(1) == 'H' && suits[1] - 1 >= 2) {
                    stopped[1] = true;
                } else if (queen.charAt(1) == 'D' && suits[2] - 1 >= 2) {
                    stopped[2] = true;
                } else if (queen.charAt(1) == 'C' && suits[3] - 1 >= 2) {
                    stopped[3] = true;
                }
            }
            boolean stoppeds = stopped[0] && stopped[1]
                    && stopped[2] && stopped[3];
            if (handValue + suitValue < 14) {
                saida.write("PASS\n");
            } else if (handValue >= 16 && stoppeds) {
                saida.write("BID NO-TRUMP\n");
            } else {
                //S, H, D, C
                String s = "";
                if (posBiggerSuit == 0) {
                    s = "S";
                } else if (posBiggerSuit == 1) {
                    s = "H";
                } else if (posBiggerSuit == 2) {
                    s = "D";
                } else if (posBiggerSuit == 3) {
                    s = "C";
                }
                saida.write("BID " + s + "\n");
            }
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

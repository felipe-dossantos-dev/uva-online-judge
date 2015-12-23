package adhoc.game.card;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Scanner;

public class UVA10205 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        int qtdTeste = entrada.nextInt();
        for (int i = 0; i < qtdTeste; i++) {
            String[] baralho = gerarBaralho();;
            int qtdTipoEmbaralhada = entrada.nextInt();
            int[][] tiposEmbaralhadas = new int[qtdTipoEmbaralhada][52];
            for (int j = 0; j < qtdTipoEmbaralhada; j++) {
                for (int k = 0; k < 52; k++) {
                    tiposEmbaralhadas[j][k] = entrada.nextInt();
                }
            }
            for (int j = 0; j < qtdTipoEmbaralhada; j++) {
                int tipo = entrada.nextInt();
                baralho = embaralhar(tiposEmbaralhadas[tipo - 1], baralho);
            }
            for (String carta : baralho) {
                saida.write(carta);
            }
            if (i != qtdTeste - 1) {
                saida.write("\n");
            }
        }
        saida.flush();
    }

    public static String[] gerarBaralho() {
        String[] baralho = new String[52];
        String[] cartas = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] naipes = {" of Clubs\n", " of Diamonds\n", " of Hearts\n", " of Spades\n"};
        int cont = 0;
        for (String naipe : naipes) {
            for (String carta : cartas) {
                baralho[cont] = carta + naipe;
                cont++;
            }
        }
        return baralho;
    }

    public static String[] embaralhar(int[] tipo, String[] baralho) {
        String[] novo = new String[52];
        for (int i = 0; i < 52; i++) {
            int novaPos = tipo[i];
            novaPos--;
            novo[i] = baralho[novaPos];
        }
        return novo;
    }
}

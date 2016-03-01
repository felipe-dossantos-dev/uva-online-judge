package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class UVA10360 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        int killed[][] = new int[1025][1025];
        for (int i = 0; i < qtdTestes; i++) {
            for (int j = 0; j < 1025; j++) {
                Arrays.fill(killed[j], 0);
            }
            linha = entrada.readLine();
            int bombStrength = Integer.parseInt(linha);
            linha = entrada.readLine();
            int rats = Integer.parseInt(linha);
            for (int j = 0; j < rats; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                int row = Integer.parseInt(vet[0]);
                int col = Integer.parseInt(vet[1]);
                int ratPopulation = Integer.parseInt(vet[2]);
                //saber o range da bomba e adicionar a todas as posicoes o valor
                int minRow = Math.max(0, row - bombStrength);
                int maxRow = Math.min(1024, row + bombStrength);
                int minCol = Math.max(0, col - bombStrength);
                int maxCol = Math.min(1024, col + bombStrength);
                for (int k = minRow; k <= maxRow; k++) {
                    for (int l = minCol; l <= maxCol; l++) {
                        killed[k][l] += ratPopulation;
                    }
                }
            }
            int posX = -1;
            int posY = -1;
            int max = -1;
            for (int j = 0; j < 1025; j++) {
                for (int k = 0; k < 1025; k++) {
                    if (killed[j][k] > max) {
                        max = killed[j][k];
                        posX = j;
                        posY = k;
                    }
                }
            }
            saida.write(String.format("%d %d %d\n", posX, posY, max));
        }
        saida.flush();
    }
}

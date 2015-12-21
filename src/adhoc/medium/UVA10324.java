package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10324 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String zerosOnes = entrada.readLine();
        int cont = 1;
        while (zerosOnes != null) {
            String linha = entrada.readLine();
            int qtdTestes = Integer.parseInt(linha);
            saida.write("Case " + cont + ":");
            saida.newLine();
            for (int k = 0; k < qtdTestes; k++) {
                linha = entrada.readLine();
                String vet[] = linha.split(" ");
                int i = Integer.parseInt(vet[0]);
                int j = Integer.parseInt(vet[1]);
                int min = Math.min(i, j);
                int max = Math.max(i, j);
                boolean yes = true;
                char base = zerosOnes.charAt(min);
                for (int l = min; l <= max; l++) {
                    if (zerosOnes.charAt(l) != base) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    saida.write("Yes");
                    saida.newLine();
                } else {
                    saida.write("No");
                    saida.newLine();
                }
            }
            zerosOnes = entrada.readLine();
            cont++;
        }
        saida.flush();
    }
}

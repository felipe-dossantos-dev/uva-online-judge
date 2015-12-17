package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11799 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTeste = Integer.parseInt(linha);
        for (int i = 1; i <= qtdTeste; i++) {
            int clown = Integer.MIN_VALUE;
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            for (int j = 1; j < vet.length; j++) {
                int tmp = Integer.parseInt(vet[j]);
                if (tmp > clown) {
                    clown = tmp;
                }
            }
            saida.write("Case " + i + ": " + clown);
            saida.newLine();
        }
        saida.flush();
    }
}

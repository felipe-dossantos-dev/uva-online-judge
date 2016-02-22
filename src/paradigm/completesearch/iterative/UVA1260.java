package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA1260 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            int size = Integer.parseInt(linha);
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            int sales[] = new int[size];
            for (int j = 0; j < size; j++) {
                sales[j] = Integer.parseInt(vet[j]);
            }
            int sum = 0;
            for (int j = 0; j < size; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    if (sales[j] >= sales[k]) {
                        sum++;
                    }
                }
            }
            saida.write(sum + "\n");
        }
        saida.flush();
    }
}

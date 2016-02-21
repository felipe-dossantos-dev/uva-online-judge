package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA927 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int n = Integer.parseInt(linha);
        int d, k;
        int[] seq = generateSequence();
        for (int i = 0; i < n; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            int[] arr = new int[vet.length];
            for (int j = 1; j < vet.length; j++) {
                arr[j - 1] = Integer.parseInt(vet[j]);
            }
            linha = entrada.readLine();
            d = Integer.parseInt(linha);
            linha = entrada.readLine();
            k = Integer.parseInt(linha);
            k = (k - 1) / d;
            int pot = seq[k];
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                int b = arr[j];
                sum += Math.pow(pot, j) * b;
            }
            saida.write(sum + "\n");
        }
        saida.flush();
    }

    public static int[] generateSequence() {
        int[] seq = new int[10000];
        int pos = 0;
        for (int i = 1; pos < 10000; i++) {
            for (int j = 0; j < i && pos < 10000; j++) {
                seq[pos] = i;
                pos++;
            }
        }
        return seq;
    }
}

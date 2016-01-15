package ds.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10038 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            String vet[] = linha.split("\\s+");
            int n = Integer.parseInt(vet[0]);
            boolean[] jollys = new boolean[n];
            int[] valores = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                valores[i] = Integer.parseInt(vet[i]);
            }
            for (int i = 1; i < valores.length - 1; i++) {
                int tmp = Math.abs(valores[i] - valores[i + 1]);
                if (tmp < n && tmp > 0 && tmp < jollys.length) {
                    jollys[tmp] = true;
                }
            }
            boolean jolly = true;
            for (int i = 1; i < jollys.length && jolly; i++) {
                boolean w = jollys[i];
                if (!w) {
                    jolly = false;
                }
            }
            if (jolly) {
                saida.write("Jolly\n");
            } else {
                saida.write("Not jolly\n");
            }
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

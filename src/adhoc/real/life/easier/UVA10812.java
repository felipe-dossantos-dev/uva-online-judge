package adhoc.real.life.easier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10812 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int qtdTestes = Integer.parseInt(entrada.readLine());
        for (int i = 0; i < qtdTestes; i++) {
            String linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            long sum = Long.parseLong(vet[0]);
            long dif = Long.parseLong(vet[1]);
            long z = (sum + dif) / 2;
            long w = (sum - dif) / 2;
            if (z + w == sum && z >= 0 && w >= 0 && dif <= sum) {
                long min = Math.min(w, z);
                long max = Math.max(w, z);
                saida.write(max + " " + min + "\n");
            } else {
                saida.write("impossible\n");
            }
        }
        saida.flush();
    }
}

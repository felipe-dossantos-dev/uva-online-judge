package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA441 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        int k = Integer.parseInt(vet[0]);
        while (k != 0) {
            List<Integer> lista = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                lista.add(Integer.parseInt(vet[i]));
            }
            for (int i = 0; i < k; i++) {
                for (int j = i; j < k; j++) {
                    for (int l = j; l < k; l++) {
                        for (int m = l; m < k; m++) {
                            for (int n = m; n < k; n++) {
                                for (int o = n; o < k; o++) {
                                    if (i != j && j != l && l != m && m != n && n != o) {
                                        saida.write(String.format("%d %d %d %d %d %d\n",
                                                lista.get(i),
                                                lista.get(j),
                                                lista.get(l),
                                                lista.get(m),
                                                lista.get(n),
                                                lista.get(o)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            k = Integer.parseInt(vet[0]);
            if (k != 0) {
                saida.write("\n");
            }
        }

        saida.flush();
    }
}

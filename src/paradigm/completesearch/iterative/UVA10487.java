package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class UVA10487 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int setSize = Integer.parseInt(linha);
        int caso = 1;
        while (setSize != 0) {
            saida.write("Case " + caso + ":\n");
            List<Integer> lista = new ArrayList<>();
            for (int i = 0; i < setSize; i++) {
                linha = entrada.readLine();
                int tmp = Integer.parseInt(linha);
                lista.add(tmp);
            }
            Collections.sort(lista);
            linha = entrada.readLine();
            int queries = Integer.parseInt(linha);
            for (int i = 0; i < queries; i++) {
                linha = entrada.readLine();
                int query = Integer.parseInt(linha);
                int val = -1;
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < setSize; j++) {
                    for (int k = 0; k < setSize; k++) {
                        if (!lista.get(k).equals(lista.get(j))) {
                            int sum = lista.get(j) + lista.get(k);
                            if (Math.abs(sum - query) < dist) {
                                dist = Math.abs(sum - query);
                                val = sum;
                            }
                        }
                    }
                }
                saida.write(String.format("Closest sum to %d is %d.\n", query, val));
            }
            linha = entrada.readLine();
            setSize = Integer.parseInt(linha);
            caso++;
        }
        saida.flush();
    }
}

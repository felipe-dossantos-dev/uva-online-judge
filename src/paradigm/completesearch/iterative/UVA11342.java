package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class UVA11342 {

    public static List<Integer> potencias;
    public static Map<Integer, Integer[]> mapa;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        potencias = new ArrayList<>();
        mapa = new HashMap<>();
        for (int j = 0; j <= 224; j++) {
            potencias.add((int) Math.pow(j, 2));
        }
        for (int j = 0; j < potencias.size(); j++) {
            int p1 = potencias.get(j);
            if (p1 <= 49998) {
                for (int k = j; k < potencias.size(); k++) {
                    int p2 = potencias.get(k);
                    if (p1 + p2 < 50000) {
                        for (int l = k; l < potencias.size(); l++) {
                            int p3 = potencias.get(l);
                            int soma = p1 + p2 + p3;
                            if (!mapa.containsKey(soma)) {
                                mapa.put(soma, new Integer[]{j, k, l});
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            int val = Integer.parseInt(linha);
            if (!mapa.containsKey(val)) {
                saida.write("-1\n");
            } else {
                Integer[] vals = mapa.get(val);
                saida.write(String.format("%d %d %d\n", vals[0], vals[1], vals[2]));
            }
        }
        saida.flush();
    }
}

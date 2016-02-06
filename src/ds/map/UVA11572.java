package ds.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class UVA11572 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            int flocos = Integer.parseInt(linha);
            int vetor[] = new int[flocos];
            for (int j = 0; j < flocos; j++) {
                linha = entrada.readLine().trim();
                int tmp = Integer.parseInt(linha);
                vetor[j] = tmp;
            }
            //percorre
            int resp = 0;
            int atual = 0;
            int block = 0;
            Map<Integer, Integer> mapa = new HashMap<>();
            for (int j = 0; j < flocos; j++) {
                if (mapa.containsKey(vetor[j])) {
                    block = Math.max(block, mapa.get(vetor[j]));
                    atual = j - block - 1;
                }
                atual++;
                mapa.put(vetor[j], j);
                resp = Math.max(resp, atual);
            }
            saida.write(resp + "\n");
        }
        saida.flush();
    }
}

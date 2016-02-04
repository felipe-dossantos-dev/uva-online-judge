package ds.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.TreeMap;

public class UVA10226 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<String, Integer> mapa;
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        linha = entrada.readLine();
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            double total = 0;
            mapa = new TreeMap<>();
            while (linha != null && !linha.isEmpty()) {
                if (mapa.containsKey(linha)) {
                    mapa.put(linha, mapa.get(linha) + 1);
                } else {
                    mapa.put(linha, 1);
                }
                total++;
                linha = entrada.readLine();
            }
            for (String key : mapa.navigableKeySet()) {
                double res = mapa.get(key) / total * 100;
                saida.write(String.format("%s %.4f\n", key, res));
            }
            if (i + 1 != qtdTestes) {
                saida.write("\n");
            }
        }
        saida.flush();
    }
}

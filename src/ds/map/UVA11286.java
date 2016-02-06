package ds.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class UVA11286 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<String, Integer> mapa;
        String linha = entrada.readLine();
        int qtdLinhas = Integer.parseInt(linha);
        while (qtdLinhas != 0) {
            mapa = new TreeMap<>();
            for (int i = 0; i < qtdLinhas; i++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                Arrays.sort(vet);
                linha = "";
                for (int j = 0; j < vet.length; j++) {
                    String vet1 = vet[j];
                    linha += vet1 + " ";
                }
                if (mapa.containsKey(linha)) {
                    mapa.put(linha, mapa.get(linha) + 1);
                } else {
                    mapa.put(linha, 1);
                }
            }
            List<Map.Entry<String, Integer>> listaT = new ArrayList<>(mapa.entrySet());
            Collections.sort(listaT, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return -o1.getValue().compareTo(o2.getValue());
                }
            });
            int ant = listaT.get(0).getValue();
            int total = 0;
            for (Map.Entry<String, Integer> pair : listaT) {
                if (ant == pair.getValue()) {
                    total += pair.getValue();
                } else {
                    break;
                }
            }
            saida.write(total + "\n");
            linha = entrada.readLine();
            qtdLinhas = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

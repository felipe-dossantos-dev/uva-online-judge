package adhoc.anagram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class UVA156 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        Map<String, Integer> mapa = new HashMap<>();
        List<String> listaOrd = new ArrayList<>();
        List<String> lista = new ArrayList<>();
        while (!linha.equals("#")) {
            String vet[] = linha.split("\\s+");
            for (String str : vet) {
                if (str.length() > 0) {
                    String menor = str.toLowerCase();
                    char[] letras = menor.toCharArray();
                    Arrays.sort(letras);
                    String ord = new String(letras);
                    if (mapa.containsKey(ord)) {
                        mapa.put(ord, mapa.get(ord) + 1);
                    } else {
                        mapa.put(ord, 1);
                    }
                    lista.add(str);
                    listaOrd.add(ord);
                }
            }
            linha = entrada.readLine();
        }
        List<String> listaSaida = new ArrayList<>();
        for (int i = listaOrd.size() - 1; i >= 0; i--) {
            String ord = listaOrd.get(i);
            if (mapa.get(ord) == 1) {
                String palavra = lista.get(i);
                listaSaida.add(palavra);
            }
        }
        Collections.sort(listaSaida);
        for (String s : listaSaida) {
            saida.write(s + "\n");
        }
        saida.flush();
    }
}

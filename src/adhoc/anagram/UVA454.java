package adhoc.anagram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class UVA454 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        linha = entrada.readLine();
        for (int i = 0; i < qtdTestes; i++) {
            List<String> listaOrd = new ArrayList<>();
            List<String> listaNorm = new ArrayList<>();
            List<String> listaRes = new ArrayList<>();
            linha = entrada.readLine();
            while (linha != null && !linha.isEmpty()) {
                char[] letras = linha.replaceAll("\\s+", "").toCharArray();
                Arrays.sort(letras);
                String ord = new String(letras);
                for (int j = 0; j < listaOrd.size(); j++) {
                    String atual = listaOrd.get(j);
                    if (ord.equals(atual)) {
                        if (linha.compareTo(listaNorm.get(j)) <= 0) {
                            listaRes.add(linha + " = " + listaNorm.get(j) + "\n");
                        } else {
                            listaRes.add(listaNorm.get(j) + " = " + linha + "\n");
                        }
                    }
                }
                listaOrd.add(ord);
                listaNorm.add(linha);
                linha = entrada.readLine();
            }
            Collections.sort(listaRes);
            for (String listaRe : listaRes) {
                saida.write(listaRe);
            }
            if (i + 1 != qtdTestes)
                saida.write("\n");
        }
        saida.flush();
    }
}

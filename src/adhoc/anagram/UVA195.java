package adhoc.anagram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class UVA195 {

    public static List<String> lista;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            lista = new ArrayList<>();
            permutacao("", linha);
            Collections.sort(lista, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    boolean maior = true;
                    int cont = 0;
                    while (maior && cont < o1.length() && cont < o2.length()) {
                        if (o1.charAt(cont) > o2.charAt(cont)) {
                            maior = false;
                        }
                        cont++;
                    }
                    return maior ? -1 : 1;
                }
            });
            for (String str : lista) {
                saida.write(str + "\n");
            }
            saida.flush();
        }
    }

    public static void permutacao(String prefix, String linha) {
        if (linha.length() == 0) {
            lista.add(prefix);
        } else {
            for (int i = 0; i < linha.length(); i++) {
                permutacao(prefix.concat(linha.substring(i, i + 1)),
                        linha.substring(0, i).concat(linha.substring(i + 1, linha.length())));
            }
        }
    }
}

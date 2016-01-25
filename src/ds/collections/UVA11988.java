package ds.collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Locale;

public class UVA11988 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            LinkedList<Character> lista = new LinkedList<>();
            boolean inicio = true;
            int idx = 0;
            for (char c : linha.toCharArray()) {
                if (c == '[') {
                    inicio = true;
                    idx = 0;
                } else if (c == ']') {
                    inicio = false;
                } else {
                    if (inicio) {
                        lista.add(idx, c);
                        idx++;
                    } else {
                        lista.add(c);
                    }
                }
            }
            StringBuilder sb = new StringBuilder(lista.size() + 1);
            for (Character lista1 : lista) {
                sb.append(lista1);
            }
            sb.append("\n");
            saida.write(sb.toString());
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA11548 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            int words = Integer.parseInt(linha);
            String prim, seg;
            List<String> lista = new ArrayList<>();
            for (int j = 0; j < words; j++) {
                lista.add(entrada.readLine());
            }
            int max = 0;
            for (int j = 0; j < words; j++) {
                prim = lista.get(j);
                for (int w = j + 1; w < words; w++) {
                    seg = lista.get(w);
                    int sum = 0;
                    for (int k = 0; k < prim.length(); k++) {
                        for (int l = 0; l < seg.length(); l++) {
                            int atual = 0;
                            if (prim.charAt(k) == seg.charAt(l)) {
                                int menorTam = Math.min(prim.length() - k, seg.length() - l);
                                for (int m = 0; m < menorTam; m++) {
                                    if (prim.charAt(k + m) == seg.charAt(l + m)) {
                                        atual++;
                                        if (atual + (menorTam - m) < max) {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (atual > sum) {
                                sum = atual;
                            }
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            saida.write(max + "\n");
        }
        saida.flush();
    }
}

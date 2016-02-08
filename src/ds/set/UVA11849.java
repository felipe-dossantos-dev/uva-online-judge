package ds.set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class UVA11849 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        int jack = Integer.parseInt(vet[0]);
        int jill = Integer.parseInt(vet[1]);
        while (jack != 0 && jill != 0) {
            int total = 0;
            Set<Integer> conj = new TreeSet<>();
            for (int i = 0; i < jack; i++) {
                linha = entrada.readLine();
                int cd = Integer.parseInt(linha);
                if (conj.contains(cd)) {
                    total++;
                } else {
                    conj.add(cd);
                }
            }
            for (int i = 0; i < jill; i++) {
                linha = entrada.readLine();
                int cd = Integer.parseInt(linha);
                if (conj.contains(cd)) {
                    total++;
                } else {
                    conj.add(cd);
                }
            }
            saida.write(total + "\n");
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            jack = Integer.parseInt(vet[0]);
            jill = Integer.parseInt(vet[1]);
        }
        saida.flush();
    }
}

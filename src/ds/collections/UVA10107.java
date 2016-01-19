package ds.collections;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UVA10107 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> lista = new ArrayList<>();
        while (entrada.hasNext()) {
            Integer i = entrada.nextInt();
            lista.add(i);
            Collections.sort(lista);
            int median = 0;
            if (lista.size() % 2 == 1) {
                int idx = (lista.size() - 1) / 2;
                median = lista.get(idx);
            } else {
                int idx = (lista.size() - 2) / 2;
                median = (lista.get(idx) + lista.get(idx + 1)) / 2;
            }
            saida.write(median + "\n");
        }
        saida.flush();
    }
}

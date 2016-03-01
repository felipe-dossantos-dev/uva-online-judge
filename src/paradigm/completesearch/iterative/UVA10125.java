package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class UVA10125 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int qtdNum = Integer.parseInt(linha);
        while (qtdNum != 0) {
            List<Long> lista = new ArrayList();
            for (int i = 0; i < qtdNum; i++) {
                linha = entrada.readLine();
                long tmp = Long.parseLong(linha);
                lista.add(tmp);
            }
            Collections.sort(lista);
            boolean flag = true;
            for (int d = lista.size() - 1; d >= 0 && flag; d--) {
                for (int x = 0; x < lista.size() && flag; x++) {
                    for (int y = x + 1; y < lista.size() && flag; y++) {
                        for (int z = y + 1; z < lista.size() && flag; z++) {
                            if (x != d
                                    && y != d
                                    && z != d
                                    && lista.get(x) + lista.get(y) + lista.get(z) == lista.get(d)) {
                                saida.write(lista.get(d) + "\n");
                                flag = false;
                            }
                        }
                    }
                }
            }
            if (flag) {
                saida.write("no solution\n");
            }
            linha = entrada.readLine();
            qtdNum = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

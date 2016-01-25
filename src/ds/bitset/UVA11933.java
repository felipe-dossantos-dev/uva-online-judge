package ds.bitset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11933 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int valor = Integer.parseInt(linha);
        while (valor != 0) {
            int a = 0;
            int b = 0;
            int cont = 0;
            for (int i = 0; i < Integer.SIZE; i++) {
                int tmp = (valor & (1 << i));
                if (tmp != 0) {
                    tmp = 1 << i;
                    cont++;
                    if (cont % 2 == 0) {
                        b |= tmp;
                    } else {
                        a |= tmp;
                    }
                }
            }
            saida.write(a + " " + b + "\n");
            linha = entrada.readLine();
            valor = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

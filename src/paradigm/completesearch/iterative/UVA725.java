package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA725 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int n = Integer.parseInt(linha);
        while (n != 0) {
            int count = 0;
            for (int fghij = 1234; fghij <= 98765 / n; fghij++) {
                int abcde = fghij * n;
                int usados = fghij < 10000 ? 1 : 0;
                int tmp = abcde;
                while (tmp != 0) {
                    usados |= 1 << (tmp % 10);
                    tmp /= 10;
                }
                tmp = fghij;
                while (tmp != 0) {
                    usados |= 1 << (tmp % 10);
                    tmp /= 10;
                }
                if (usados == (1 << 10) - 1) {
                    saida.write(String.format("%05d / %05d = %d\n", abcde, fghij, n));
                    count++;
                }
            }
            if (count == 0) {
                saida.write("There are no solutions for " + n + ".\n");
            }
            linha = entrada.readLine();
            n = Integer.parseInt(linha);
            if (n != 0) {
                saida.write("\n");
            }
        }
        saida.flush();
    }
}

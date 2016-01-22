package ds.bitset;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Locale;
import java.util.Scanner;

public class UVA1241 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int testes = entrada.nextInt();
        for (int i = 0; i < testes; i++) {
            int n = entrada.nextInt();
            int m = entrada.nextInt();
            BitSet bs = new BitSet(1 << n);
            bs.set(0, 1 << n);
            for (int j = 0; j < m; j++) {
                int tmp = entrada.nextInt();
                tmp--;
                bs.clear(tmp);
            }
            int cont = 0;
            n = 1 << n;
            while (n > 1) {
                int idx = 0;
                for (int j = 0; j < n; j += 2) {
                    if (bs.get(j) ^ bs.get(j + 1)) {
                        cont++;
                    }
                    bs.set(idx, bs.get(j + 1) | bs.get(j));
                    idx++;
                }
                n = n >> 1;
            }
            saida.write(cont + "\n");
        }
        saida.flush();
    }
}

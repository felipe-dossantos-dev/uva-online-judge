package ds.bitset;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Locale;
import java.util.Scanner;

public class UVA11760 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
        int r = entrada.nextInt();
        int c = entrada.nextInt();
        int n = entrada.nextInt();
        int caso = 1;
        BitSet cols = new BitSet(10005);
        BitSet rows = new BitSet(10005);
        while (r != 0 && c != 0 && n != 0) {
            saida.write("Case " + caso + ": ");
            for (int i = 0; i < n; i++) {
                int x = entrada.nextInt();
                int y = entrada.nextInt();
                rows.set(x);
                cols.set(y);
            }
            int x = entrada.nextInt();
            int y = entrada.nextInt();
            if ((!rows.get(x) && !cols.get(y))
                    || (x - 1 >= 0 && !rows.get(x - 1) && !cols.get(y))
                    || (x + 1 < r && !rows.get(x + 1) && !cols.get(y))
                    || (y - 1 >= 0 && !cols.get(y - 1) && !rows.get(x))
                    || (y + 1 < c && !cols.get(y + 1)) && !rows.get(x)) {
                saida.write("Escaped again! More 2D grid problems!\n");
            } else {
                saida.write("Party time! Let's find a restaurant!\n");
            }
            r = entrada.nextInt();
            c = entrada.nextInt();
            n = entrada.nextInt();
            cols.clear();
            rows.clear();
            caso++;
        }
        saida.flush();
    }
}

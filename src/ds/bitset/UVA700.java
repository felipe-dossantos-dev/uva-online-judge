package ds.bitset;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Locale;
import java.util.Scanner;

public class UVA700 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int computers = entrada.nextInt();
        int caso = 1;
        while (computers != 0) {
            int answer = 0;
            if (computers != 1) {
                BitSet bs = null;
                int ai = 0;
                for (int i = 0; i < computers; i++) {
                    BitSet resp = new BitSet(10005);
                    int y = entrada.nextInt();
                    int a = entrada.nextInt();
                    int b = entrada.nextInt();

                    if (a > ai) {
                        ai = a;
                    }

                    int diff = Math.abs(b - a);
                    for (int j = y; j < 10000; j += diff) {
                        resp.set(j);
                    }
                    if (i == 0) {
                        bs = resp;
                    } else {
                        bs.and(resp);
                    }
                }
                answer = bs.nextSetBit(ai);
            } else {
                int y = entrada.nextInt();
                int a = entrada.nextInt();
                int b = entrada.nextInt();
                answer = y;
            }
            saida.write("Case #" + caso + ":\n");
            if (answer == -1) {
                saida.write("Unknown bugs detected.\n");
            } else {
                saida.write("The actual year is " + answer + ".\n");
            }
            saida.write("\n");
            caso++;
            computers = entrada.nextInt();
        }
        saida.flush();
    }
}

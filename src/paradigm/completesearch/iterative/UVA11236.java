package paradigm.completesearch.iterative;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11236 {

    public static long PROD_MAX = 1000000;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a = 1; a <= 2000; a++) {
            if (a * a * a * a > 2000000000) {
                break;
            }
            for (int b = a; b <= 2000 - a; b++) {
                if (a * b * b * b > 2000000000) {
                    break;
                }
                for (int c = b; c <= 2000 - a - b; c++) {
                    if (a * b * c * c > 2000000000) {
                        break;
                    }
                    long prod = a * b * c;
                    if (prod == PROD_MAX) {
                        continue;
                    }

                    long x = a + b + c;
                    long soma = x * PROD_MAX;
                    long e = prod - PROD_MAX;

                    if (soma % e != 0) {
                        continue;
                    }

                    long d = soma / e;
                    if (c > d) {
                        continue;
                    }
                    if (x + d > 2000) {
                        continue;
                    }
                    if (prod * d > 2000000000) {
                        continue;
                    }
                    saida.write(String.format("%.2f %.2f %.2f %.2f\n", a / 100.0, b / 100.0, c / 100.0, d / 100.0));
                }
            }
        }
        saida.flush();
    }
}

package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10424 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String amante1 = entrada.readLine();
        while (amante1 != null) {
            String amante2 = entrada.readLine();
            amante1 = amante1.toLowerCase();
            amante2 = amante2.toLowerCase();
            double val1 = calculo(amante1);
            double val2 = calculo(amante2);
            double max = Math.max(val1, val2);
            double min = Math.min(val1, val2);
            double ratio = min / max * 100;
            saida.write(String.format("%.2f", ratio));
            saida.write(" %");
            saida.newLine();
            amante1 = entrada.readLine();
        }
        saida.flush();
    }

    public static double calculo(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sum += c - 'a' + 1;
            }
        }
        String a = Integer.toString(sum);
        while (a.length() > 1) {
            int s = 0;
            for (char c : a.toCharArray()) {
                s += c - '0';
            }
            a = Integer.toString(s);
        }
        return Double.parseDouble(a);
    }
}

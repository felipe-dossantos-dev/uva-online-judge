package ds.bitset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA594 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));

        String linha = entrada.readLine();
        while (linha != null) {
            int a = Integer.parseInt(linha);
            int b = Integer.reverseBytes(a);
            saida.write(a + " converts to " + b + "\n");
            linha = entrada.readLine();
        }

        saida.flush();
    }
}

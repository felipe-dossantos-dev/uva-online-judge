package adhoc.palindrome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10945 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (!linha.equals("DONE")) {
            linha = linha.replaceAll("[?!\\s.,]", "");
            linha = linha.toLowerCase();
            boolean pali = true;
            for (int i = 0; i < linha.length() / 2; i++) {
                if (linha.charAt(i) != linha.charAt(linha.length() - i - 1)) {
                    pali = false;
                }
            }
            if (pali) {
                saida.write("You won't be eaten!");
            } else {
                saida.write("Uh oh..");
            }
            saida.write("\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

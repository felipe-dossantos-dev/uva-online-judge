package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class UVA11956 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        int[] bytes = new int[100];
        for (int i = 0; i < qtdTestes; i++) {
            Arrays.fill(bytes, 0);
            linha = entrada.readLine();
            int pos = 0;
            for (char c : linha.toCharArray()) {
                if (c == '+') {
                    int a = bytes[pos];
                    a++;
                    a = (a + 256) % 256;
                    bytes[pos] = a;
                } else if (c == '-') {
                    int a = bytes[pos];
                    a--;
                    a = (a + 256) % 256;
                    bytes[pos] = a;
                } else if (c == '<') {
                    pos--;
                    pos = (pos + 100) % 100;
                } else if (c == '>') {
                    pos++;
                    pos = (pos + 100) % 100;
                }
            }
            saida.write("Case " + (i + 1) + ":");
            for (int j = 0; j < 100; j++) {
                saida.write(String.format(" %02X", bytes[j]));
            }
            saida.newLine();
        }
        saida.flush();
    }
}

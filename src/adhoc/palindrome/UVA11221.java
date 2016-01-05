package adhoc.palindrome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11221 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            linha = linha.replaceAll("\\W+", "");
            int tam = (int) Math.sqrt(linha.length());
            saida.write("Case #" + (i + 1) + ":\n");
            if (tam * tam == linha.length()) {
                char magic[][] = new char[tam][tam];
                for (int j = 0; j < tam; j++) {
                    for (int k = 0; k < tam; k++) {
                        magic[j][k] = linha.charAt(j * tam + k);
                    }
                }
                if (isMagic(magic)) {
                    saida.write(tam + "\n");
                } else {
                    saida.write("No magic :(\n");
                }
            } else {
                saida.write("No magic :(\n");
            }
        }
        saida.flush();
    }

    private static boolean isMagic(char[][] magic) {
        int tam = magic.length;
        StringBuilder right = new StringBuilder(tam * tam);
        StringBuilder left = new StringBuilder(tam * tam);
        StringBuilder down = new StringBuilder(tam * tam);
        StringBuilder up = new StringBuilder(tam * tam);
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                right.append(magic[i][j]);
            }
        }
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                down.append(magic[j][i]);
            }
        }
        for (int i = tam - 1; i >= 0; i--) {
            for (int j = tam - 1; j >= 0; j--) {
                left.append(magic[i][j]);
            }
        }
        for (int i = tam - 1; i >= 0; i--) {
            for (int j = tam - 1; j >= 0; j--) {
                up.append(magic[j][i]);
            }
        }
        boolean equal = true;
        for (int i = 0; i < tam && equal; i++) {
            for (int j = 0; j < tam && equal; j++) {
                if (up.charAt(i) != down.charAt(i)
                        || down.charAt(i) != left.charAt(i)
                        || left.charAt(i) != right.charAt(i)) {
                    equal = false;
                }
            }
        }
        return equal;
    }
}

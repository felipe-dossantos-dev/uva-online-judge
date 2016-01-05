package adhoc.palindrome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA401 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            boolean palindrome = palindrome(linha);
            boolean mirror = mirrored(linha);
            saida.write(linha);
            if (palindrome && mirror) {
                saida.write(" -- is a mirrored palindrome.");
            } else if (palindrome) {
                saida.write(" -- is a regular palindrome.");
            } else if (mirror) {
                saida.write(" -- is a mirrored string.");
            } else {
                saida.write(" -- is not a palindrome.");
            }
            saida.write("\n\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }

    private static boolean palindrome(String linha) {
        boolean palin = true;
        for (int i = 0; i < linha.length() / 2 + 1 && palin; i++) {
            if (linha.charAt(i) != linha.charAt(linha.length() - i - 1)) {
                palin = false;
            }
        }
        return palin;
    }

    private static boolean mirrored(String linha) {
        boolean mirr = true;
        for (int i = 0; i < linha.length() / 2 + 1 && mirr; i++) {
            if (!mirror(linha.charAt(i), linha.charAt(linha.length() - i - 1))) {
                mirr = false;
            }
        }
        return mirr;
    }

    public static boolean mirror(char um, char outra) {
        if (um == outra && (um == 'A'
                || um == 'H'
                || um == 'I'
                || um == 'M'
                || um == 'O'
                || um == 'T'
                || um == 'U'
                || um == 'V'
                || um == 'W'
                || um == 'X'
                || um == 'Y'
                || um == '1'
                || um == '8')) {
            return true;
        }
        if ((um == '3' && outra == 'E')
                || (um == 'E' && outra == '3')) {
            return true;
        }
        if ((um == 'J' && outra == 'L')
                || (um == 'L' && outra == 'J')) {
            return true;
        }
        if ((um == 'S' && outra == '2')
                || (um == '2' && outra == 'S')) {
            return true;
        }
        if ((um == '5' && outra == 'Z')
                || (um == 'Z' && outra == '5')) {
            return true;
        }
        return false;
    }
}

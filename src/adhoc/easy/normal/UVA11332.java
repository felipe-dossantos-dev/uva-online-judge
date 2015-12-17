package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11332 {

    public static String linha;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        linha = entrada.readLine();
        while (!linha.equals("0")) {
            func(linha);
            saida.write(linha);
            saida.newLine();
            linha = entrada.readLine();
        }
        saida.flush();
    }

    public static void func(String s) {
        int soma = 0;
        for (char c : s.toCharArray()) {
            soma += c - '0';
        }
        linha = Integer.toString(soma);
        if (soma > 9) {
            func(linha);
        }
    }
}

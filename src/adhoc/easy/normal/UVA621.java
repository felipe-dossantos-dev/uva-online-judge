package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA621 {

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
            if (linha.equals("1") || linha.equals("4") || linha.equals("78")) {
                saida.write("+");
            } else if (linha.endsWith("35")) {
                saida.write("-");
            } else if (linha.endsWith("4") && linha.startsWith("9")) {
                saida.write("*");
            } else if (linha.startsWith("190")) {
                saida.write("?");
            }
            saida.newLine();
        }
        saida.flush();
    }
}

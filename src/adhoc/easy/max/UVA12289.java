package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12289 {

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
            if (linha.length() == 3) {
                if (linha.contains("o") && linha.contains("n")
                        || linha.contains("o") && linha.contains("e")
                        || linha.contains("n") && linha.contains("e")) {
                    saida.write("1");
                } else {
                    saida.write("2");
                }
            } else {
                saida.write("3");
            }
            saida.newLine();
        }
        saida.flush();
    }
}

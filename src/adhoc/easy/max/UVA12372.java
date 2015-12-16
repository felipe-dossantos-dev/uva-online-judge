package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12372 {

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
            String vet[] = linha.split(" ");
            boolean cabeNaCaixa = true;
            for (String a : vet) {
                int tmp = Integer.parseInt(a);
                if (tmp > 20) {
                    cabeNaCaixa = false;
                }
            }
            saida.write("Case " + (i + 1) + ": ");
            if (cabeNaCaixa) {
                saida.write("good\n");
            } else {
                saida.write("bad\n");
            }
        }
        saida.flush();
    }
}

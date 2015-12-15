package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11172 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTeste = Integer.parseInt(linha);
        for (int i = 0; i < qtdTeste; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            int n = Integer.parseInt(vet[0]);
            int m = Integer.parseInt(vet[1]);
            if (n == m) {
                saida.write("=");
            } else if (n > m) {
                saida.append(">");
            } else {
                saida.append("<");
            }
            saida.newLine();
        }
        saida.flush();
    }
}

package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12403 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        int conta = 0;
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            if (vet[0].equals("donate")) {
                int tmp = Integer.parseInt(vet[1]);
                conta += tmp;
            } else {
                saida.write(conta + "\n");
            }
        }
        saida.flush();
    }
}

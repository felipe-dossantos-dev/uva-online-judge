package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12015 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTeste = Integer.parseInt(linha);
        for (int i = 0; i < qtdTeste; i++) {
            String vetor[] = new String[10];
            int valores[] = new int[10];
            int maior = - 1;
            saida.append("Case #" + (i + 1) + ":");
            saida.newLine();
            for (int j = 0; j < 10; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split(" ");
                int tmp = Integer.parseInt(vet[1]);
                valores[j] = tmp;
                vetor[j] = vet[0];
                if (tmp > maior) {
                    maior = tmp;
                }
            }
            for (int j = 0; j < 10; j++) {
                if (maior == valores[j]) {
                    saida.write(vetor[j]);
                    saida.newLine();
                }
            }
        }
        saida.flush();
    }
}

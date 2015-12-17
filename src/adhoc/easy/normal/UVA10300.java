package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10300 {

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
            int qtdFazendeiros = Integer.parseInt(linha);
            int soma = 0;
            for (int j = 0; j < qtdFazendeiros; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split(" ");
                int tamanhoFazenda = Integer.parseInt(vet[0]);
                int ecoAmigavel = Integer.parseInt(vet[2]);
                soma += tamanhoFazenda * ecoAmigavel;
            }
            saida.write(soma + "\n");
        }
        saida.flush();
    }
}

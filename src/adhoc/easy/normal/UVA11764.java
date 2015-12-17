package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11764 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 1; i <= qtdTestes; i++) {
            int qtdParedes = Integer.parseInt(entrada.readLine());
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            int highJump = 0;
            int lowJump = 0;
            int anterior = Integer.parseInt(vet[0]);
            int atual = anterior;
            for (int j = 1; j < qtdParedes; j++) {
                atual = Integer.parseInt(vet[j]);
                if (atual > anterior) {
                    lowJump++;
                } else if (atual < anterior) {
                    highJump++;
                }
                anterior = atual;
            }
            saida.write("Case " + i);
            saida.write(": " + lowJump + " " + highJump);
            saida.newLine();
        }
        saida.flush();
    }
}

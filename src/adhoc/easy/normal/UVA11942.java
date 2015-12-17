package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11942 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        saida.write("Lumberjacks:");
        saida.newLine();
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            int primeiro = Integer.parseInt(vet[0]);
            int segundo = Integer.parseInt(vet[1]);
            boolean asc = primeiro <= segundo;
            boolean ord = true;
            int anterior = segundo;
            for (int j = 2; j < 10; j++) {
                int tmp = Integer.parseInt(vet[j]);
                if (asc) {
                    if (tmp < anterior) {
                        ord = false;
                        break;
                    }
                } else {
                    if (tmp > anterior) {
                        ord = false;
                        break;
                    }
                }
                anterior = tmp;
            }
            if (ord) {
                saida.write("Ordered");
            } else {
                saida.write("Unordered");
            }
            saida.newLine();
        }
        saida.flush();
    }
}

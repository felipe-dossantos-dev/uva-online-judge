package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11498 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTeste = Integer.parseInt(linha);
        while (qtdTeste != 0) {
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            int x = Integer.parseInt(vet[0]);
            int y = Integer.parseInt(vet[1]);
            for (int i = 0; i < qtdTeste; i++) {
                linha = entrada.readLine();
                vet = linha.split(" ");
                int x2 = Integer.parseInt(vet[0]);
                int y2 = Integer.parseInt(vet[1]);
                if (x2 > x) {
                    if (y2 > y) {
                        saida.write("NE");
                    } else if (y2 < y) {
                        saida.write("SE");
                    } else {
                        saida.write("divisa");
                    }
                } else if (x2 < x) {
                    if (y2 > y) {
                        saida.write("NO");
                    } else if (y2 < y) {
                        saida.write("SO");
                    } else {
                        saida.write("divisa");
                    }
                } else {
                    saida.write("divisa");
                }
                saida.newLine();
            }
            linha = entrada.readLine();
            qtdTeste = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

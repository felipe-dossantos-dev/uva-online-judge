package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12157 {

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
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            int mile = 0;
            int juice = 0;
            for (String s : vet) {
                int tmp = Integer.parseInt(s);
                mile += (1 + tmp / 30) * 10;
                juice += (1 + tmp / 60) * 15;
            }
            saida.write("Case " + (i + 1) + ": ");
            if (mile > juice) {
                saida.write("Juice " + juice);
            } else if (juice > mile) {
                saida.write("Mile " + mile);
            } else {
                saida.write("Mile Juice " + mile);
            }
            saida.newLine();
        }
        saida.flush();
    }
}

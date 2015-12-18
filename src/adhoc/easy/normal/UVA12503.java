package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA12503 {

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
            int qtdInstrucoes = Integer.parseInt(linha);
            List<String> lista = new ArrayList<>();
            int pos = 0;
            for (int j = 0; j < qtdInstrucoes; j++) {
                linha = entrada.readLine();
                if (linha.contains("SAME AS")) {
                    String vet[] = linha.split(" ");
                    int tmp = Integer.parseInt(vet[2]);
                    tmp--;
                    String s = lista.get(tmp);
                    if (s.equals("LEFT")) {
                        pos--;
                        lista.add("LEFT");
                    } else {
                        pos++;
                        lista.add("RIGHT");
                    }
                } else if (linha.equals("LEFT")) {
                    pos--;
                    lista.add(linha);
                } else {
                    pos++;
                    lista.add("RIGHT");
                }
            }
            saida.write(pos + "\n");
        }
        saida.flush();
    }
}

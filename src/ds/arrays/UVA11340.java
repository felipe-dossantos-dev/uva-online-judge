package ds.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class UVA11340 {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            int qtdChars = Integer.parseInt(linha);
            Map<Character, Integer> mapa = new HashMap<>();
            for (int j = 0; j < qtdChars; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                int valor = Integer.parseInt(vet[1]);
                char a = vet[0].charAt(0);
                mapa.put(a, valor);
            }
            linha = entrada.readLine();
            long total = 0;
            int qtdLinhas = Integer.parseInt(linha);
            for (int j = 0; j < qtdLinhas; j++) {
                linha = entrada.readLine();
                for (char c : linha.toCharArray()) {
                    if (mapa.containsKey(c)) {
                        total += mapa.get(c);
                    }
                }
            }
            long cents = total % 100;
            total /= 100;
            saida.write(String.format("%d.%02d$\n", total, cents));
        }
        saida.flush();
    }
}

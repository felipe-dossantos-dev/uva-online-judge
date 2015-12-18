package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class UVA119 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            int qtdPessoas = Integer.parseInt(linha);
            linha = entrada.readLine();
            String vet[] = linha.split(" ");
            Map<String, Integer> mapa = new LinkedHashMap<>();
            for (String s : vet) {
                mapa.put(s, 0);
            }
            for (int i = 0; i < qtdPessoas; i++) {
                linha = entrada.readLine();
                vet = linha.split(" ");
                int valor = Integer.parseInt(vet[1]);
                int qtdPresentes = Integer.parseInt(vet[2]);
                if (qtdPresentes != 0) {
                    valor /= qtdPresentes;
                }
                for (int j = 3; j < qtdPresentes + 3; j++) {
                    mapa.put(vet[j], mapa.get(vet[j]) + valor);
                    mapa.put(vet[0], mapa.get(vet[0]) - valor);
                }
            }
            for (Map.Entry<String, Integer> e : mapa.entrySet()) {
                saida.write(e.getKey() + " " + e.getValue());
                saida.newLine();
            }
            linha = entrada.readLine();
            if (linha != null) {
                saida.newLine();
            }
        }
        saida.flush();
    }
}

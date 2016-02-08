package ds.set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.TreeMap;

public class UVA11136 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int qtdLinhas = Integer.parseInt(linha);
        while (qtdLinhas != 0) {
            TreeMap<Long, Integer> urna = new TreeMap<>();
            long total = 0;
            for (int i = 0; i < qtdLinhas; i++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                int qtdContas = Integer.parseInt(vet[0]);
                for (int j = 1; j <= qtdContas; j++) {
                    long cont = Long.parseLong(vet[j]);
                    if (urna.containsKey(cont)) {
                        urna.put(cont, urna.get(cont) + 1);
                    } else {
                        urna.put(cont, 1);
                    }

                }
                long menor = urna.firstKey();
                long maior = urna.lastKey();
                retirar(urna, maior);
                retirar(urna, menor);
                total += maior - menor;
            }
            saida.write(total + "\n");
            linha = entrada.readLine();
            qtdLinhas = Integer.parseInt(linha);
        }
        saida.flush();
    }

    public static void retirar(TreeMap<Long, Integer> urna, Long chave) {
        int quantidade = urna.get(chave);
        if (quantidade == 1) {
            urna.remove(chave);
        } else {
            urna.put(chave, urna.get(chave) - 1);
        }
    }
}

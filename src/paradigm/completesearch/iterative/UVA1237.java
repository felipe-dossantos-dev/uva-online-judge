package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA1237 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        List<String> marcas = new ArrayList<>(10005);
        List<Integer> menores = new ArrayList<>(10005);
        List<Integer> maiores = new ArrayList<>(10005);
        for (int i = 0; i < testes; i++) {
            marcas.clear();
            menores.clear();
            maiores.clear();
            linha = entrada.readLine();
            int database = Integer.parseInt(linha);
            for (int j = 0; j < database; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                marcas.add(vet[0]);
                menores.add(Integer.parseInt(vet[1]));
                maiores.add(Integer.parseInt(vet[2]));
            }
            linha = entrada.readLine();
            int querys = Integer.parseInt(linha);
            int query;
            for (int j = 0; j < querys; j++) {
                int resp = 0;
                int pos = -1;
                linha = entrada.readLine();
                query = Integer.parseInt(linha);
                for (int k = 0; k < menores.size(); k++) {
                    int menor = menores.get(k);
                    int maior = maiores.get(k);
                    if (query >= menor && query <= maior) {
                        resp++;
                        pos = k;
                        if (resp > 1) {
                            break;
                        }
                    }
                }
                if (resp != 1) {
                    saida.write("UNDETERMINED\n");
                } else {
                    saida.write(marcas.get(pos) + "\n");
                }
            }
            if (i != testes - 1) {
                saida.write("\n");
            }
        }
        saida.flush();
    }
}

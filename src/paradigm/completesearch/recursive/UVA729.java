package paradigm.completesearch.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA729 {

    public static int size;
    public static int distance;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            entrada.readLine();
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            size = Integer.parseInt(vet[0]);
            distance = Integer.parseInt(vet[1]);
            generate(saida, "", 0);
            if (i + 1 != testes) {
                saida.write("\n");
            }
        }

        saida.flush();
    }

    public static void generate(BufferedWriter saida, String actual, int dist) throws IOException {
        if (actual.length() == size && dist == distance) {
            saida.write(actual);
            saida.write("\n");
        } else if (actual.length() < size) {
            generate(saida, actual + "0", dist);
            generate(saida, actual + "1", dist + 1);
        }
    }
}

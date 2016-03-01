package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11565 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int n = Integer.parseInt(linha);
        for (int i = 0; i < n; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            int a = Integer.parseInt(vet[0]);
            int b = Integer.parseInt(vet[1]);
            int c = Integer.parseInt(vet[2]);
            boolean flag = true;
            for (int x = -100; x <= 100 && flag; x++) {
                for (int y = -100; y < 100 && flag; y++) {
                    for (int z = -100; z <= 100 && flag; z++) {
                        if (x != y && y != z && z != x
                                && x + y + z == a
                                && x * y * z == b
                                && x * x + y * y + z * z == c) {
                            saida.write(String.format("%d %d %d\n", x, y, z));
                            flag = false;
                        }
                    }
                }
            }
            if (flag) {
                saida.write("No solution.\n");
            }
        }
        saida.flush();
    }

    public static void outraSolucao(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            int a = Integer.parseInt(vet[0]);
            int b = Integer.parseInt(vet[1]);
            int c = Integer.parseInt(vet[2]);
            boolean flag = true;
            for (int x = -100; x <= 100 && flag; x++) {
                int x2 = x * x;
                for (int y = x + 1; y <= a - x && flag; y++) {
                    int y2 = y * y;
                    if (y * y <= c - x2) {
                        for (int z = y + 1; z <= a - x - y && flag; z++) {
                            if (x2 + y2 + z * z == c && x * y * z == b && x + y + z == a) {
                                saida.write(String.format("%d %d %d\n", x, y, z));
                                flag = false;
                            }
                        }
                    }
                }
            }
            if (flag) {
                saida.write("No solution.\n");
            }
        }
        saida.flush();
    }
}

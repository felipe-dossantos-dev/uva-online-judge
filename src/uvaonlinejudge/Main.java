package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
        String linha = entrada.readLine();
        List<String> lista = new ArrayList<>(100000);
        while (linha != null) {
            long k = Long.parseLong(linha);
            long max = 2 * k;
            long qtd = 0, x;
            for (long y = k + 1; y <= max; y++) {
                x = (-k * y) / (k - y);
                if (k == (x * y) / (x + y)) {
                    lista.add(String.format("1/%d = 1/%d + 1/%d\n", k, x, y));
                    qtd++;
                }
            }
            saida.write(qtd + "\n");
            for (String l : lista) {
                saida.write(l);
            }
            lista.clear();
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            Map<String, Integer> mapa = new HashMap<>();
            int flocos = Integer.parseInt(linha);
            int maior = 0;
            String vetor[] = new String[flocos + 1];
            for (int j = 1; j <= flocos; j++) {
                linha = entrada.readLine();
                vetor[j] = linha;
                if (mapa.containsKey(linha)) {
                    
                }
                mapa.put(linha, j);
            }
            if (maior == 0) maior++;
            saida.write(maior + "\n");
        }
        saida.flush();
    }
}

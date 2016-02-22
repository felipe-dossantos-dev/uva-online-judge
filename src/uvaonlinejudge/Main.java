package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

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
        int score = Integer.parseInt(linha);
        
        Set<Integer> values = new HashSet<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 20; j++) {
                values.add(i * j);
            }
        }
        values.add(50);
        
        while (score > 0) {
            int perm = 0;
            for (Integer i : values) {
                for (Integer j : values) {
                    for (Integer k : values) {
                        if (i + j + k == score) {
                            perm++;
                        }
                    }
                }
            }
            saida.write(perm + "\n");
            linha = entrada.readLine();
            score = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

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
import java.util.Map;

public class Main {

    public static List<Integer> potencias;
    public static Map<Integer, Integer[]> mapa;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));C:\Users\felipe.santos\Documents\
//        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            int words = Integer.parseInt(linha);
            String prim, seg;
            List<String> lista = new ArrayList<>();
            for (int j = 0; j < words; j++) {
                lista.add(entrada.readLine());
            }
            int max = 0;
            for (int j = 0; j < words; j++) {
                prim = lista.get(j);
                for (int w = j + 1; w < words; w++) {
                    seg = lista.get(w);
                    int sum = 0;
                    for (int k = 0; k < prim.length(); k++) {
                        for (int l = 0; l < seg.length(); l++) {
                            int atual = 0;
                            if (prim.charAt(k) == seg.charAt(l)) {
                                int menorTam = Math.min(prim.length() - k, seg.length() - l);
                                for (int m = 0; m < menorTam; m++) {
                                    if (prim.charAt(k + m) != seg.charAt(l + m)) {
                                        break;
                                    }
                                    atual++;
                                }
                            }
                            if (atual > sum) {
                                sum = atual;
                            }
                        }
                    }
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            saida.write(max + "\n");
        }
        saida.flush();
    }
}

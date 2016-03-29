package uvaonlinejudge;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static int n;
    public static char[][] matriz;
    public static Set<String> conj;
    public static Set<Character> letras;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        int testes = entrada.nextInt();
        for (int i = 0; i < testes; i++) {
            conj = new HashSet<>();
            if (i == 0) {
                entrada.nextLine();
            }
            entrada.nextLine(); // ler a quebra de linha
            n = entrada.nextInt();
            entrada.nextLine();
            matriz = new char[n][n];
            for (int j = 0; j < n; j++) {
                matriz[j] = entrada.nextLine().trim().toCharArray();
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    StringBuilder sb = new StringBuilder(n * n);
                    backtrack(j, k, sb);
                }
            }
        }
        saida.flush();
    }

    private static void backtrack(int col, int lin, StringBuilder sb) {
        if (sb.length() < n * n) {
            if (col - 1 >= 0) {
                StringBuilder s1 = new StringBuilder(sb);
                s1.append(matriz[lin][col - 1]);
                backtrack(col - 1, lin, s1);
                if (lin + 1 < n) {
                    StringBuilder s2 = new StringBuilder(sb);
                    s2.append(matriz[lin + 1][col - 1]);
                    backtrack(col - 1, lin + 1, s2);
                }
                if (lin - 1 >= 0) {
                    StringBuilder s3 = new StringBuilder(sb);
                    s3.append(matriz[lin - 1][col - 1]);
                    backtrack(col - 1, lin - 1, s3);
                }
            }
            if (col + 1 < n) {
                StringBuilder s1 = new StringBuilder(sb);
                s1.append(matriz[lin][col + 1]);
                backtrack(col + 1, lin, s1);
                if (lin + 1 < n) {
                    StringBuilder s2 = new StringBuilder(sb);
                    s2.append(matriz[lin + 1][col + 1]);
                    backtrack(col + 1, lin + 1, s2);
                }
                if (lin - 1 >= 0) {
                    StringBuilder s3 = new StringBuilder(sb);
                    s3.append(matriz[lin - 1][col + 1]);
                    backtrack(col + 1, lin - 1, s3);
                }
            }
            if (lin + 1 < n) {
                StringBuilder s2 = new StringBuilder(sb);
                s2.append(matriz[lin + 1][col]);
                backtrack(col, lin + 1, s2);
            }
            if (lin - 1 >= 0) {
                StringBuilder s3 = new StringBuilder(sb);
                s3.append(matriz[lin - 1][col]);
                backtrack(col, lin - 1, s3);
            }
        }
        if (sb.length() >= 3 && sb.length() < n * n) {
            System.out.println(sb.toString());
        }
    }

}

package uvaonlinejudge;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static boolean[][] graph;
    public static boolean[] visited;
    public static int walkN;
    public static int size;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        size = entrada.nextInt();
        walkN = entrada.nextInt();
        System.out.println(walkN);
        graph = new boolean[11][11];
        visited = new boolean[11];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int tmp = entrada.nextInt();
                graph[i][j] = tmp == 1;
            }
        }
        backtrack(saida, 0, 0);
        saida.write("\n");
        saida.flush();
    }

    private static void backtrack(BufferedWriter saida, int pos, int cont) throws IOException {
        if (cont == walkN) {
            saida.write("(");
            for (int i = 0; i < size; i++) {
                if (visited[i]){
                    saida.write((i + 1) + ",");
                }
            }
            saida.write(")\n");
        } else if (cont < walkN) {
            for (int i = 0; i < size; i++) {
                if (graph[pos][i] && !visited[i]) {
                    visited[pos] = true;
                    backtrack(saida, i, cont + 1);
                    visited[pos] = false;
                }
            }
        }
    }

}

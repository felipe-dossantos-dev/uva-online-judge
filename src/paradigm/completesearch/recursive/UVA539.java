package paradigm.completesearch.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Scanner;

public class UVA539 {

    public static boolean[][] graph;
    public static boolean[][] visitedEdges;
    public static int bigger = 0;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int nodes = entrada.nextInt();
        int edges = entrada.nextInt();
        while (nodes != 0 && edges != 0) {
            graph = new boolean[26][26];
            visitedEdges = new boolean[26][26];
            for (int i = 0; i < edges; i++) {
                int a = entrada.nextInt();
                int b = entrada.nextInt();
                graph[a][b] = true;
                graph[b][a] = true;
            }
            bigger = 0;
            for (int i = 0; i < nodes; i++) {
                backtrack(i, nodes, 0);
            }
            saida.write(bigger + "\n");
            nodes = entrada.nextInt();
            edges = entrada.nextInt();
        }
        saida.flush();
    }

    public static void backtrack(int node, int nodes, int actual) {
        if (actual > bigger) {
            bigger = actual;
        }
        for (int i = 0; i < nodes; i++) {
            if (graph[node][i] && !visitedEdges[node][i]) {
                visitedEdges[node][i] = true;
                visitedEdges[i][node] = true;
                backtrack(i, nodes, actual + 1);
                visitedEdges[node][i] = false;
                visitedEdges[i][node] = false;
            }
        }
    }
}

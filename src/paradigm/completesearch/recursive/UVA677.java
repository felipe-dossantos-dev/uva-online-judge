package paradigm.completesearch.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Scanner;

public class UVA677 {

    public static boolean[][] graph;
    public static boolean[] visited;
    public static int[] positions;
    public static int walkN;
    public static int size;
    public static int qtd;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        while (entrada.hasNext()) {
            positions = new int[11];
            size = entrada.nextInt();
            walkN = entrada.nextInt();
            graph = new boolean[11][11];
            visited = new boolean[11];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int tmp = entrada.nextInt();
                    graph[i][j] = tmp == 1;
                }
            }
            qtd = 0;
            backtrack(saida, 0, 0);
            if (qtd == 0) {
                saida.write("no walk of length " + walkN + "\n");
            }
            if (entrada.hasNext()) {
                entrada.nextInt();
                saida.write("\n");
            }
        }
        saida.flush();
    }

    private static void backtrack(BufferedWriter saida, int pos, int cont) throws IOException {
        if (cont == walkN) {
            qtd++;
            saida.write("(");
            for (int i = 0; i < cont; i++) {
                saida.write(positions[i] + ",");
            }
            saida.write((pos + 1) + ")\n");
        } else {
            for (int i = 0; i < size; i++) {
                if (graph[pos][i] && !visited[i]) {
                    positions[cont] = pos + 1;
                    visited[pos] = true;
                    backtrack(saida, i, cont + 1);
                    visited[pos] = false;
                }
            }
        }
    }

}

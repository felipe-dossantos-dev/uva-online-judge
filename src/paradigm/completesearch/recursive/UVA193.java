package paradigm.completesearch.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA193 {

    public static boolean graph[][];
    public static boolean color[];
    public static int nodes, edges;
    public static List<Integer> vertices;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(entrada.readLine());
        for (int t = 0; t < m; t++) {
            String linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            nodes = Integer.parseInt(vet[0]);
            edges = Integer.parseInt(vet[1]);
            graph = new boolean[nodes + 1][nodes + 1];
            color = new boolean[nodes + 1];
            vertices = new ArrayList<>(nodes);
            for (int i = 0; i < edges; i++) {
                linha = entrada.readLine();
                vet = linha.split("\\s+");
                int a = Integer.parseInt(vet[0]);
                int b = Integer.parseInt(vet[1]);
                graph[a][b] = true;
                graph[b][a] = true;
            }
            coloring(1);
            saida.write(vertices.size() + "\n");
            for (int i = 0; i < vertices.size(); i++) {
                Integer vertice = vertices.get(i);
                saida.write(vertice.toString());
                if (i != vertices.size() - 1) {
                    saida.write(" ");
                }
            }
            saida.write("\n");
        }
        saida.flush();
    }

    public static void coloring(int pos) {
        if (pos <= nodes) {
            boolean podeSerPreto = true;
            for (int i = 1; i <= nodes && podeSerPreto; i++) {
                //visitar quais ainda nao visitei
                if (graph[pos][i] && color[i]) {
                    podeSerPreto = false;
                }
            }
            if (podeSerPreto) {
                color[pos] = true;
                coloring(pos + 1);
                color[pos] = false;
            }
            coloring(pos + 1);
        } else {
            int c = 0;
            for (boolean d : color) {
                if (d) {
                    c++;
                }
            }
            if (c > vertices.size()) {
                vertices.clear();
                for (int i = 1; i < color.length; i++) {
                    boolean d = color[i];
                    if (d) {
                        vertices.add(i);
                    }
                }
            }
        }
    }
}

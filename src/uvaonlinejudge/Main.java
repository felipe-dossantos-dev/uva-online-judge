package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {

    public static int vis[] = new int[300];
    public static boolean graph[][] = new boolean[300][300];
    public static boolean temCiclo;
    public static int n;
    public static List<Integer> caminho;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        while (linha != null) {
            n = Integer.parseInt(linha);
            Arrays.fill(vis, 0);
            for (int i = 0; i < 300; i++) {
                Arrays.fill(graph[i], false);
            }
            temCiclo = false;
            caminho = null;
            linha = entrada.readLine();
            while (!linha.contains("%")) {
                String vet[] = linha.split("\\s+");
                int a = Integer.parseInt(vet[0]) - 1;
                int b = Integer.parseInt(vet[1]) - 1;
                graph[a][b] = true;
                linha = entrada.readLine();
            }
            for (int i = 0; i < n; i++) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                vis[i] = 1;
                backtrack(i, l, -1);
                vis[i] = 0;
            }
            if (caminho == null) {
                saida.write("N\n");
            } else {
                for (Integer c : caminho) {
                    saida.write(c + " ");
                }
                saida.write("\n");
            }
            linha = entrada.readLine();
        }
        saida.flush();
    }

    public static void backtrack(int posInicial, List<Integer> l, int posAtual) {
        if (posInicial == posAtual) {
            temCiclo = true;
            caminho = l;
        } else if (!temCiclo) {
            for (int i = 0; i < n; i++) {
                if (vis[i] == 0) {
                    vis[i] = 1;
                    List<Integer> l1 = new ArrayList<>(l);
                    l.add(i);
                    backtrack(posInicial, l1, i);
                    vis[i] = 0;
                }
            }
        }
    }
}

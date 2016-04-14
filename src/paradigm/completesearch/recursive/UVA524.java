package paradigm.completesearch.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UVA524 {

    public static boolean vis[] = new boolean[17];
    public static List<List<Integer>> lista = new ArrayList<>();
    public static int n;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));///home/felipe/
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
        int caso = 1;
        while (entrada.hasNextInt()) {
            Arrays.fill(vis, false);
            n = entrada.nextInt();
            vis[1] = true;
            List<Integer> list = new ArrayList<>();
            list.add(1);
            lista.clear();
            backtrack(1, 1, list);
            saida.write("Case " + caso + ":\n");
            for (List<Integer> l : lista) {
                for (int i = 0; i < l.size(); i++) {
                    saida.write(l.get(i).toString());
                    if (i + 1 != l.size()) {
                        saida.write(" ");
                    }
                }
                saida.write("\n");
            }
            if (entrada.hasNextInt()) {
                saida.write("\n");
            }
            caso++;
        }
        saida.flush();
    }

    public static void backtrack(int qtd, int ant, List<Integer> li) {
        if (qtd == n) {
            lista.add(li);
        } else if (qtd + 1 == n) {
            for (int i = 2; i <= n; i++) {
                if (!vis[i] && isPrimo(i + ant) && isPrimo(i + 1)) {
                    vis[i] = true;
                    List<Integer> l = new ArrayList<>(li);
                    l.add(i);
                    backtrack(qtd + 1, i, l);
                    vis[i] = false;
                }
            }
        } else if (qtd < n) {
            for (int i = 2; i <= n; i++) {
                if (!vis[i] && isPrimo(i + ant)) {
                    vis[i] = true;
                    List<Integer> l = new ArrayList<>(li);
                    l.add(i);
                    backtrack(qtd + 1, i, l);
                    vis[i] = false;
                }
            }
        }
    }

    public static boolean isPrimo(int k) {
        return k == 1
                || k == 2
                || k == 3
                || k == 5
                || k == 7
                || k == 11
                || k == 13
                || k == 17
                || k == 19
                || k == 23
                || k == 29
                || k == 31;
    }
}

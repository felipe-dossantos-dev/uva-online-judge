package paradigm.completesearch.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UVA487 {

    public static int n;
    public static char[][] matriz;
    public static boolean[][] visitado;
    public static Set<String> conj;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
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
                    Set<Character> set = new TreeSet<>();
                    set.add(matriz[j][k]);
                    backtrack(k, j, matriz[j][k], set);
                }
            }
            List<String> lista = new ArrayList<>(conj);
            lista.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else if (o1.length() < o2.length()) {
                        return -1;
                    }
                    return o1.compareTo(o2);
                }
            });
            for (int j = 0; j < lista.size(); j++) {
                String s = lista.get(j);
                saida.write(s);
                saida.write("\n");
            }
            if (i + 1 != testes) {
                saida.write("\n");
            }
        }
        saida.flush();
    }

    private static void backtrack(int col, int lin, char ant, Set<Character> sb) {
        if (sb.size() < n * n) {
            if (col - 1 >= 0) {
                if (!sb.contains(matriz[lin][col - 1]) && matriz[lin][col - 1] > ant) {
                    Set<Character> s1 = new TreeSet<>(sb);
                    s1.add(matriz[lin][col - 1]);
                    backtrack(col - 1, lin, matriz[lin][col - 1], s1);
                }
                if (lin + 1 < n && !sb.contains(matriz[lin + 1][col - 1]) && matriz[lin + 1][col - 1] > ant) {
                    Set<Character> s2 = new TreeSet<>(sb);
                    s2.add(matriz[lin + 1][col - 1]);
                    backtrack(col - 1, lin + 1, matriz[lin + 1][col - 1], s2);
                }
                if (lin - 1 >= 0 && !sb.contains(matriz[lin - 1][col - 1]) && matriz[lin - 1][col - 1] > ant) {
                    Set<Character> s3 = new TreeSet<>(sb);
                    s3.add(matriz[lin - 1][col - 1]);
                    backtrack(col - 1, lin - 1, matriz[lin - 1][col - 1], s3);
                }
            }
            if (col + 1 < n) {
                if (!sb.contains(matriz[lin][col + 1]) && matriz[lin][col + 1] > ant) {
                    Set<Character> s1 = new TreeSet<>(sb);
                    s1.add(matriz[lin][col + 1]);
                    backtrack(col + 1, lin, matriz[lin][col + 1], s1);
                }
                if (lin + 1 < n && !sb.contains(matriz[lin + 1][col + 1]) && matriz[lin + 1][col + 1] > ant) {
                    Set<Character> s2 = new TreeSet<>(sb);
                    s2.add(matriz[lin + 1][col + 1]);
                    backtrack(col + 1, lin + 1, matriz[lin + 1][col + 1], s2);
                }
                if (lin - 1 >= 0 && !sb.contains(matriz[lin - 1][col + 1]) && matriz[lin - 1][col + 1] > ant) {
                    Set<Character> s3 = new TreeSet<>(sb);
                    s3.add(matriz[lin - 1][col + 1]);
                    backtrack(col + 1, lin - 1, matriz[lin - 1][col + 1], s3);
                }
            }
            if (lin + 1 < n && !sb.contains(matriz[lin + 1][col]) && matriz[lin + 1][col] > ant) {
                Set<Character> s2 = new TreeSet<>(sb);
                s2.add(matriz[lin + 1][col]);
                backtrack(col, lin + 1, matriz[lin + 1][col], s2);
            }
            if (lin - 1 >= 0 && !sb.contains(matriz[lin - 1][col]) && matriz[lin - 1][col] > ant) {
                Set<Character> s3 = new TreeSet<>(sb);
                s3.add(matriz[lin - 1][col]);
                backtrack(col, lin - 1, matriz[lin - 1][col], s3);
            }
        }
        if (sb.size() >= 3 && sb.size() <= n * n) {
            StringBuilder sbs = new StringBuilder(sb.size());
            for (Character sb1 : sb) {
                sbs.append(sb1);
            }
            if (!conj.contains(sbs.toString())) {
                conj.add(sbs.toString());
            }
        }
    }

}

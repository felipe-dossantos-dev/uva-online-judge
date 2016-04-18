package paradigm.completesearch.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class UVA574 {

    public static Set<List<Integer>> respostas = new LinkedHashSet<>();
    public static int soma;
    public static List<Integer> numeros = new ArrayList<>();
    public static boolean vis[];

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        soma = entrada.nextInt();
        int qtd = entrada.nextInt();
        while (soma != 0 && qtd != 0) {
            respostas.clear();
            numeros.clear();
            vis = new boolean[qtd];
            for (int i = 0; i < qtd; i++) {
                numeros.add(entrada.nextInt());
            }
            backtrack(0, 0, new ArrayList<>());
            saida.write("Sums of " + soma + ":\n");
            if (respostas.size() > 0) {
                for (List<Integer> resposta : respostas) {
                    for (int i = 0; i < resposta.size(); i++) {
                        saida.append(resposta.get(i) + "");
                        if (i + 1 != resposta.size()) {
                            saida.write("+");
                        }
                    }
                    saida.write("\n");
                }
            } else {
                saida.write("NONE\n");
            }
            soma = entrada.nextInt();
            qtd = entrada.nextInt();
        }
        saida.flush();
    }

    private static void backtrack(int pos, int sum, List<Integer> caminho) {
        if (sum == soma) {
            respostas.add(caminho);
        } else if (sum < soma) {
            for (int i = pos; i < numeros.size(); i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    List<Integer> l = new ArrayList<>(caminho);
                    l.add(numeros.get(i));
                    backtrack(i, sum + numeros.get(i), l);
                    vis[i] = false;
                }
            }
        }
    }
}

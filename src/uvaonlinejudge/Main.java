package uvaonlinejudge;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    
    public static List<List<Integer>> respostas = new ArrayList<>();
    public static int soma;
    public static List<Integer> numeros = new ArrayList<>();
    public static boolean vis[];
    
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
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
            for (List<Integer> resposta : respostas) {
                for (Integer resposta1 : resposta) {
                    saida.write(resposta1 + " ");
                }
                saida.write("\n");
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

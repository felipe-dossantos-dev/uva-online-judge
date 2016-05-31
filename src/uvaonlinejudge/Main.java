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
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Main {

    public static char[][] lida;
    public static char[][] primeira;
    public static char[][] segunda;
    public static int n;
    public static int d;
    public static boolean flag;
    public static Set<List<Character>> conj;
    public static List<Character> resp;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
//        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int k = 0; k < testes; k++) {
            linha = entrada.readLine();
            n = Integer.parseInt(linha);

            conj = new HashSet<>();
            lida = new char[6][5];
            primeira = new char[5][6];
            segunda = new char[5][6];
            leitura(entrada, primeira);
            leitura(entrada, segunda);

            flag = false;
            d = 0;
            backtrack(0, new ArrayList<Character>());
            if (flag) {
                StringBuilder sb = new StringBuilder();
                for (Character resp1 : resp) {
                    sb.append(resp1);
                }
                saida.write(sb.toString());
            } else {
                saida.write("NO");
            }
            saida.write("\n");
        }
        saida.flush();
    }

    public static void leitura(BufferedReader entrada, char[][] vet) throws IOException {
        String linha;
        for (int i = 0; i < 6; i++) {
            linha = entrada.readLine();
            lida[i] = linha.trim().toCharArray();
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                vet[j][i] = lida[i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            Arrays.sort(vet[i]);
        }
    }

    public static void backtrack(int l, List<Character> caminho) {
//        System.out.println("l: " + l + " c1: " + c1 + " c2: " + c2 + " cam: " + caminho);
        if (!flag && d != n && l < 5) {
            for (int i = 0; i < 6 && !flag; i++) {
                for (int j = 0; j < 6 && !flag; j++) {
                    if (primeira[l][i] == segunda[l][j]) {
                        List<Character> novo = new ArrayList(caminho);
                        novo.add(primeira[l][i]);
                        if (l == 4) {
                            if (!conj.contains(novo)) {
                                d++;
                                conj.add(novo);
                                if (d == n) {
                                    resp = novo;
                                    flag = true;
                                }
                            }
                        } else {
                            backtrack(l + 1, novo);
                        }
                    }
                }
            }
        }
    }
}

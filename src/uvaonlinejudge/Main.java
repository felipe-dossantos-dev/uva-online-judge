package uvaonlinejudge;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static final boolean nums[][] = {
        {true, true, true, true, true, true, false},
        {false, true, true, false, false, false, false},
        {true, true, false, true, true, false, true},
        {true, true, true, true, false, false, true},
        {false, true, true, false, false, true, true},
        {true, false, true, true, false, true, true},
        {true, false, true, true, true, true, true},
        {true, true, true, false, false, false, false},
        {true, true, true, true, true, true, true},
        {true, true, true, true, false, true, true}};

    public static boolean match;
    public static int n;
    public static boolean matriz[][];

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        while (true) {
            n = entrada.nextInt();
            if (n == 0) {
                break;
            }
            matriz = new boolean[n][7];
            for (int i = 0; i < n; i++) {
                String linha = entrada.next();
                for (int j = 0; j < linha.length(); j++) {
                    char a = linha.charAt(j);
                    matriz[i][j] = a == 'Y';
                }
            }
            match = false;
            backtrack(0, 9, new boolean[7]);
            if (!match) {
                saida.write("MIS");
            }
            saida.write("MATCH\n");
        }
        saida.flush();
    }

    public static void backtrack(int pos, int valor, boolean queimados[]) {
        if (pos < n && valor >= 0) {
            boolean q[] = confereQueimados(pos, valor);
            boolean f = formaSequencia(queimados, q);
            if (f) {
                backtrack(pos + 1, valor - 1, q);
            } else {
                backtrack(pos, valor - 1, queimados);
            }
        } else if (pos >= n){
            match = true;
        }
    }

    public static boolean[] confereQueimados(int pos, int num) {
        boolean queimados[] = new boolean[7];
        for (int i = 0; i < 7; i++) {
            if (nums[num][i] && !matriz[pos][i]) {
                queimados[i] = true;
            }
        }
        return queimados;
    }

    public static boolean formaSequencia(boolean[] ant, boolean[] atu) {
        boolean flag = true;
        for (int i = 0; i < 7 && flag; i++) {
            if (ant[i] && !atu[i]) {
                flag = false;
            }
        }
        return flag;
    }
}

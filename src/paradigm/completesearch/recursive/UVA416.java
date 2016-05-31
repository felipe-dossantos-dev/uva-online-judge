package paradigm.completesearch.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class UVA416 {

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
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
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
            if (pos == 0) {
                boolean forma = podeFormar(pos, valor);
                if (forma) {
                    boolean[] quei = confereQueimados(pos, valor);
                    backtrack(pos + 1, valor - 1, quei);
                }
                backtrack(pos, valor - 1, queimados);
            } else {
                boolean forma = podeFormarQueimado(pos, valor, queimados);
                if (forma) {
                    boolean[] quei = confereNovoQueimados(pos, valor, queimados);
                    if (evoluiQueimadoAnterior(queimados, quei)) {
                        backtrack(pos + 1, valor - 1, quei);
                    }
                }
            }
        } else if (pos >= n) {
            match = true;
        }
    }

    public static boolean[] confereQueimados(int pos, int valor) {
        boolean queimados[] = new boolean[7];
        for (int i = 0; i < 7; i++) {
            if (nums[valor][i] && !matriz[pos][i]) {
                queimados[i] = true;
            }
        }
        return queimados;
    }

    public static boolean podeFormar(int pos, int valor) {
        boolean flag = true;
        for (int i = 0; i < 7 && flag; i++) {
            if (!nums[valor][i] && matriz[pos][i]) {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean evoluiQueimadoAnterior(boolean[] anterior, boolean atual[]) {
        boolean flag = true;
        for (int i = 0; i < 7 && flag; i++) {
            if (anterior[i] && !atual[i]) {
                flag = false;
            }
        }
        return flag;
    }

    private static boolean podeFormarQueimado(int pos, int valor, boolean[] queimados) {
        boolean flag = true;
        for (int i = 0; i < 7 && flag; i++) {
            if (queimados[i] && matriz[pos][i]) {
                flag = false;
            }
            if (!nums[valor][i] && matriz[pos][i] && !queimados[i]) {
                flag = false;
            }
        }
        return flag;
    }

    private static boolean[] confereNovoQueimados(int pos, int valor, boolean[] queimados) {
        boolean novo[] = Arrays.copyOf(queimados, 7);
        for (int i = 0; i < 7; i++) {
            if (nums[valor][i] && !matriz[pos][i] && !queimados[i]) {
                novo[i] = true;
            }
        }
        return novo;
    }
}

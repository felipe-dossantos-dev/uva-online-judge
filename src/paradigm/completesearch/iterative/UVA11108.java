package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Stack;

public class UVA11108 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        while (!linha.contains("0")) {
            String vet[] = linha.split("\\s+");
            linha = String.join("", vet);
            char[] s = linha.toCharArray();
            boolean ok = true;
            for (int i = 0; i < 1 << 5; i++) {
                ok = ok && evaluate(i, s);
            }
            if (ok) {
                saida.write("tautology\n");
            } else {
                saida.write("not\n");
            }
            linha = entrada.readLine();
        }
        saida.flush();
    }

    private static boolean evaluate(int mask, char[] arr) {
        Stack<Boolean> res = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (map(arr[i]) != -1) {
                res.push((1 << map(arr[i]) & mask) != 0);
            } else {
                if (arr[i] == 'K') {
                    boolean a = res.pop();
                    boolean b = res.pop();
                    res.push(a && b);
                }
                if (arr[i] == 'A') {
                    boolean a = res.pop();
                    boolean b = res.pop();
                    res.push(a || b);
                }
                if (arr[i] == 'N') {
                    res.push(!res.pop());
                }
                if (arr[i] == 'C') {
                    boolean a = res.pop();
                    boolean b = res.pop();
                    res.push(!a || b);
                }
                if (arr[i] == 'E') {
                    boolean a = res.pop();
                    boolean b = res.pop();
                    res.push(a == b);
                }
            }
        }
        return res.pop();
    }

    public static int map(char c) {
        if (c == 'p') {
            return 0;
        }
        if (c == 'q') {
            return 1;
        }
        if (c == 'r') {
            return 2;
        }
        if (c == 's') {
            return 3;
        }
        if (c == 't') {
            return 4;
        }
        return -1;
    }
}

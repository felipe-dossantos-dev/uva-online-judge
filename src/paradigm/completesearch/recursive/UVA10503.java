package paradigm.completesearch.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10503 {

    public static int[][] domino;
    public static int[][] pecas;
    public static boolean[] vis;
    public static int m, n;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(entrada.readLine());
        while (n != 0) {
            m = Integer.parseInt(entrada.readLine());
            domino = new int[n + 2][2];
            pecas = new int[m][2];
            vis = new boolean[m];
            lerPeca(entrada, 0, domino);
            lerPeca(entrada, n + 1, domino);
            for (int i = 0; i < m; i++) {
                lerPeca(entrada, i, pecas);
            }
            flag = false;
            backtrack(1);
            if (flag) {
                saida.write("YES\n");
            } else {
                saida.write("NO\n");
            }
            n = Integer.parseInt(entrada.readLine());
        }
        saida.flush();
    }

    public static void lerPeca(BufferedReader entrada, int pos, int[][] matriz) throws NumberFormatException, IOException {
        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        int primeira = Integer.parseInt(vet[0]);
        int segunda = Integer.parseInt(vet[1]);
        matriz[pos][0] = primeira;
        matriz[pos][1] = segunda;
    }

    public static void backtrack(int pos) {
        if (!flag && pos <= n) {
            for (int i = 0; i < m; i++) {
                if (!vis[i] && domino[pos - 1][1] == pecas[i][0]) {
                    vis[i] = true;
                    domino[pos][0] = pecas[i][0];
                    domino[pos][1] = pecas[i][1];
                    backtrack(pos + 1);
                    vis[i] = false;
                } else if (!vis[i] && domino[pos - 1][1] == pecas[i][1]) {
                    vis[i] = true;
                    domino[pos][1] = pecas[i][0];
                    domino[pos][0] = pecas[i][1];
                    backtrack(pos + 1);
                    vis[i] = false;
                }
            }
        } else if (pos > n && domino[pos][0] == domino[pos - 1][1]) {
            flag = true;
        }
    }
}

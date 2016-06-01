package paradigm.completesearch.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class UVA1262 {

    public static char[][] lida;
    public static char[][] primeira;
    public static char[][] segunda;
    public static int n;
    public static int d;
    public static boolean flag;
    public static String resp;
    public static List<List<Character>> repetidos;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        lida = new char[7][7];
        primeira = new char[5][6];
        segunda = new char[5][6];
        repetidos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            repetidos.add(new ArrayList<>());
        }
        for (int k = 0; k < testes; k++) {
            linha = entrada.readLine();
            n = Integer.parseInt(linha);

            for (int i = 0; i < 10; i++) {
                repetidos.get(i).clear();
            }
            leitura(entrada, primeira);
            leitura(entrada, segunda);

            flag = false;
            d = 0;
            backtrack(0, new int[5]);
            if (flag) {
                saida.write(resp);
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

    public static void backtrack(int l, int[] caminho) {
        if (!flag && d != n && l < 5) {
            for (int i = 0; i < 6 && !flag; i++) {
                for (int j = 0; j < 6 && !flag; j++) {
                    if (primeira[l][i] == segunda[l][j] && !repetidos.get(l).contains(primeira[l][i])) {
                        repetidos.get(l).add(primeira[l][i]);
                        if (l == 4) {
                            d++;
                            if (d == n) {
                                caminho[l] = i;
                                String str = formaString(caminho);
                                resp = str;
                                flag = true;
                            }
                        } else {
                            int[] novo = Arrays.copyOf(caminho, 5);
                            novo[l] = i;
                            backtrack(l + 1, novo);
                        }
                    }
                }
            }
            repetidos.get(l).clear();
        }
    }

    public static String formaString(int[] novo) {
        StringBuilder sb = new StringBuilder(7);
        for (int i = 0; i < 5; i++) {
            sb.append(primeira[i][novo[i]]);
        }
        return sb.toString();
    }
}

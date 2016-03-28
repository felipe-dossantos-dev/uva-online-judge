package paradigm.completesearch.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA10452 {

    public static char[] letras = {'I', 'E', 'H', 'O', 'V', 'A', '#'};
    public static int iniLin = -1;
    public static int iniCol = -1;
    public static int lin = -1;
    public static int col = -1;
    public static char[][] matriz;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            lin = Integer.parseInt(vet[0]);
            col = Integer.parseInt(vet[1]);
            matriz = new char[lin][col];
            iniLin = -1;
            iniCol = -1;
            for (int j = 0; j < lin; j++) {
                linha = entrada.readLine();
                matriz[j] = linha.trim().toCharArray();
                for (int k = 0; k < col; k++) {
                    if (matriz[j][k] == '@') {
                        iniLin = j;
                        iniCol = k;
                    }
                }
            }
            List<String> caminho = new ArrayList<>();
            backtrack(iniLin, iniCol, 0, caminho);
            for (int j = 0; j < caminho.size(); j++) {
                String c = caminho.get(j);
                saida.write(c);
                if (j + 1 != caminho.size()) {
                    saida.write(" ");
                } else {
                    saida.write("\n");
                }
            }
        }
        saida.flush();
    }

    private static void backtrack(int linAtual, int colAtual, int pos, List<String> caminho) {
        if (matriz[linAtual][colAtual] == letras[6]) {
            return;
        }
        if (pos < 7) {
            //forth
            if (linAtual - 1 >= 0 && matriz[linAtual - 1][colAtual] == letras[pos]) {
                caminho.add("forth");
                backtrack(linAtual - 1, colAtual, pos + 1, caminho);
            }
            //dir
            if (colAtual + 1 < col && matriz[linAtual][colAtual + 1] == letras[pos]) {
                caminho.add("right");
                backtrack(linAtual, colAtual + 1, pos + 1, caminho);
            }
            //esq
            if (colAtual - 1 >= 0 && matriz[linAtual][colAtual - 1] == letras[pos]) {
                caminho.add("left");
                backtrack(linAtual, colAtual - 1, pos + 1, caminho);
            }
        }
    }
}

package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12455 {
    /**
     * Escrevendo aqui os que deveria ser escrito no txt
     * 
     * 
     * 3.2.1.1- porque vc pode diminuir a busca divindo por N, enquanto começando 
     * com abcde não da pra garantir que esse espaço de busca seja cortado
     * 
     * 3.2.1.2 - 10! = 3628800 ~ 4x10^6 e depois tem que iterar para saber se cada numero 
     * eh unico O(8) = 3 X 10^7 e depois uma multiplicacao pra saber se eh valor O(n) = 6 x 10^7
     * bem provalvel que passa
     * 
     * 3.2.1.3 - já fiz
     * 
     * 3.2.1.4 - 
     */

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int tests = Integer.parseInt(linha);
        for (int i = 0; i < tests; i++) {
            linha = entrada.readLine();
            int obtain = Integer.parseInt(linha);
            linha = entrada.readLine();
            int numBars = Integer.parseInt(linha);
            int bars[] = new int[numBars];
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            for (int j = 0; j < numBars; j++) {
                int tmp = Integer.parseInt(vet[j]);
                bars[j] = tmp;
            }
            boolean flag = false;
            for (int j = 0; j < (1 << numBars); j++) {
                int sum = 0;
                for (int k = 0; k < numBars; k++) {
                    if ((j & (1 << k)) != 0) {
                        sum += bars[k];
                    }
                }
                if (sum == obtain) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                saida.write("YES\n");
            } else {
                saida.write("NO\n");
            }
        }
        saida.flush();
    }
}

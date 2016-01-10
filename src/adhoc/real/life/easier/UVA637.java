package adhoc.real.life.easier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA637 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int paginas = Integer.parseInt(entrada.readLine());
        while (paginas != 0) {
            saida.write(String.format("Printing order for %d pages:\n", paginas));
            int folhas = paginas / 4 + (paginas % 4 > 0 ? 1 : 0);
            int[] vet = new int[(folhas * 4) + 1];
            int cont = 0;
            int j = 1;
            int k = vet.length - 1;
            for (int i = 0; i <= paginas; i++) {
                vet[i] = i;
            }
            for (int i = 1; i <= folhas && cont < paginas; i++) {
                String primeira = "Blank";
                String segunda = "Blank";
                if (vet[j] != 0) {
                    cont++;
                    primeira = Integer.toString(vet[j]);
                }
                if (vet[k] != 0) {
                    cont++;
                    segunda = Integer.toString(vet[k]);
                }
                saida.write(String.format("Sheet %d, front: %s, %s\n", i, segunda, primeira));
                j++;
                k--;
                if (cont < paginas) {
                    primeira = "Blank";
                    segunda = "Blank";
                    if (vet[j] != 0) {
                        cont++;
                        primeira = Integer.toString(vet[j]);
                    }
                    if (vet[k] != 0) {
                        cont++;
                        segunda = Integer.toString(vet[k]);
                    }
                    saida.write(String.format("Sheet %d, back : %s, %s\n", i, primeira, segunda));
                    j++;
                    k--;
                }
            }
            paginas = Integer.parseInt(entrada.readLine());
        }
        saida.flush();
    }
}

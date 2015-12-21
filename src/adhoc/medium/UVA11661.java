package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11661 {
     public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int tamanho = Integer.parseInt(linha);
        while (tamanho != 0) {
            linha = entrada.readLine(); 
            int menorDist = 999999;
            int ultDrog = -1;
            int ultRest = -1;
            for (int i = 0; i < tamanho; i++) {
                char c = linha.charAt(i);
                if (c == 'Z') {
                    menorDist = 0;
                } else if (c == 'R') {
                    ultRest = i;
                } else if (c == 'D') {
                    ultDrog = i;
                }
                if (ultDrog != -1 
                        && ultRest != -1 
                        && Math.abs(ultDrog - ultRest) < menorDist) {
                    menorDist = Math.abs(ultDrog - ultRest);
                }
            }
            saida.write(menorDist + "");
            saida.newLine();
            linha = entrada.readLine();
            tamanho = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12468 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int a = Integer.parseInt(vet[0]);
        int b = Integer.parseInt(vet[1]);
        while (a != -1 && b != -1) {
            int res;
            if (a < 50 && b < 50) {
                res = Math.abs(a - b);
            } else if (a >= 50 && b >= 50) {
                res = Math.abs(a - b);
            } else {
                res = Math.min(Math.min(Math.abs(100 - a + b), Math.abs(a - b)), Math.abs(100 + a - b));
            }
            saida.write(res + "\n");
            linha = entrada.readLine();
            vet = linha.split(" ");
            a = Integer.parseInt(vet[0]);
            b = Integer.parseInt(vet[1]);
        }
        saida.flush();
    }
}

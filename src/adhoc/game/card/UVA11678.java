package adhoc.game.card;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class UVA11678 {

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
        int cartasA[] = new int[100005];
        int cartasB[] = new int[100005];
        while (a != 0 && b != 0) {
            int trocasA = 0;
            int trocasB = 0;
            linha = entrada.readLine();
            vet = linha.split(" ");
            for (String str : vet) {
                int pos = Integer.parseInt(str);
                cartasA[pos]++;
            }
            linha = entrada.readLine();
            vet = linha.split(" ");
            for (String str : vet) {
                int pos = Integer.parseInt(str);
                cartasB[pos]++;
            }
            for (int i = 0; i < cartasA.length; i++) {
                if (cartasA[i] != 0 && cartasB[i] == 0) {
                    trocasA++;
                }
                if ((cartasA[i] == 0 && cartasB[i] != 0)) {
                    trocasB++;
                }
            }
            trocasA = Math.min(trocasA, trocasB);
            saida.write(trocasA + "\n");

            linha = entrada.readLine();
            vet = linha.split(" ");
            a = Integer.parseInt(vet[0]);
            b = Integer.parseInt(vet[1]);
            Arrays.fill(cartasA, 0);
            Arrays.fill(cartasB, 0);
        }
        saida.flush();
    }
}

package adhoc.real.life.harder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA608 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int qtdTestes = Integer.parseInt(entrada.readLine());
        for (int i = 0; i < qtdTestes; i++) {
            int[] up = new int[12];
            int[] down = new int[12];
            int[] even = new int[12];
            for (int j = 0; j < 3; j++) {
                String linha = entrada.readLine();
                String[] vet = linha.split("\\s+");
                if (vet[2].contains("up")) {
                    for (char c : vet[0].toCharArray()) {
                        down[c - 'A']--;
                    }
                    for (char c : vet[1].toCharArray()) {
                        up[c - 'A']++;
                    }
                } else if (vet[2].contains("down")) {
                    for (char c : vet[0].toCharArray()) {
                        up[c - 'A']++;
                    }
                    for (char c : vet[1].toCharArray()) {
                        down[c - 'A']--;
                    }
                } else {
                    for (char c : vet[0].toCharArray()) {
                        even[c - 'A']++;
                    }
                    for (char c : vet[1].toCharArray()) {
                        even[c - 'A']++;
                    }
                }
            }
            int certo = 0;
            int maior = 0;
            boolean cima = true;
            boolean primeira = true;
            String a = "ABCDEFGHIJKL";
            for (int j = 0; j < 12; j++) {
                if (even[j] == 0 && (up[j] != 0 || down[j] != 0) && up[j] + down[j] != 0) {
                    if (primeira) {
                        if (up[j] < Math.abs(down[j])) {
                            cima = false;
                            maior = Math.abs(down[j]);
                        } else {
                            maior = up[j];
                        }
                        certo = j;
                        primeira = false;
                    } else {
                        if (up[j] < Math.abs(down[j]) && Math.abs(down[j]) > maior) {
                            cima = false;
                            maior = Math.abs(down[j]);
                            certo = j;
                        } else if (up[j] > maior) {
                            cima = true;
                            maior = up[j];
                            certo = j;
                        }
                    }
                }
            }
            if (cima) {
                saida.write(a.substring(certo, certo + 1) + " is the counterfeit coin and it is light.");
            } else {
                saida.write(a.substring(certo, certo + 1) + " is the counterfeit coin and it is heavy.");
            }
            saida.write("\n");
        }
        saida.flush();
    }
}

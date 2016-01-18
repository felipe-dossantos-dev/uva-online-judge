package ds.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10855 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        int maior = Integer.parseInt(vet[0]);
        int menor = Integer.parseInt(vet[1]);
        while (maior != 0 && menor != 0) {
            char big[][] = new char[maior][maior];
            char lit[][] = new char[menor][menor];
            int res[] = new int[4];
            for (int i = 0; i < maior; i++) {
                linha = entrada.readLine();
                big[i] = linha.toCharArray();
            }
            for (int i = 0; i < menor; i++) {
                linha = entrada.readLine();
                lit[i] = linha.toCharArray();
            }
            for (int i = 0; i < 4; i++) {
                if (i != 0) {
                    //rodar 90
                    char[][] rot = new char[menor][menor];
                    for (int j = 0; j < menor; j++) {
                        for (int k = 0; k < menor; k++) {
                            rot[k][menor - 1 - j] = lit[j][k];
                        }
                    }
                    lit = rot;
                }
                for (int j = 0; j <= maior - menor; j++) {
                    for (int k = 0; k <= maior - menor; k++) {
                        boolean acertou = true;
                        for (int l = 0; l < menor && acertou; l++) {
                            for (int m = 0; m < menor && acertou; m++) {
                                if (big[j + l][k + m] != lit[l][m]) {
                                    acertou = false;
                                }
                            }
                        }
                        if (acertou) {
                            res[i]++;
                        }
                    }
                }
            }
            saida.write(String.format("%d %d %d %d\n", res[0], res[1], res[2], res[3]));
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            maior = Integer.parseInt(vet[0]);
            menor = Integer.parseInt(vet[1]);
        }
        saida.flush();
    }
}

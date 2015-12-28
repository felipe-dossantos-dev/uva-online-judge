package adhoc.game.card;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class UVA12247 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int princesa[] = new int[3];
        int princepe[] = new int[2];
        leitura(linha, princesa, princepe);
        while (continua(princesa, princepe)) {
            int vence[] = new int[2];
            Arrays.sort(princesa);
            for (int i = 0; i < princepe.length; i++) {
                int ele = princepe[i];
                for (int j = 0; j < princesa.length; j++) {
                    int ela = princesa[j];
                    if (ele > ela) {
                        vence[i]++;
                    }
                }
            }
            if ((vence[0] == 0 && vence[1] != 3)
                    || (vence[0] != 3 && vence[1] == 0)
                    || (vence[0] == 1 && vence[1] == 1)
                    || (vence[0] == 2 && vence[1] == 1)
                    || (vence[0] == 1 && vence[1] == 2)) {
                saida.write("-1\n");
            } else {
                //2 de 3
                if (vence[0] == 3 && vence[1] == 3) {
                    int menor = 1;
                    while (contem(menor, princesa, princepe)) {
                        menor++;
                    }
                    saida.write(menor + "\n");
                } // 2 de 2
                // 1 de 3 e 1 de 2
                else if ((vence[0] == 2 && vence[1] == 2)
                        || (vence[0] == 3 && vence[1] == 2)
                        || (vence[0] == 2 && vence[1] == 3)) {
                    int menor = princesa[1];
                    menor++;
                    while (menor < 52 && contem(menor, princesa, princepe)) {
                        menor++;
                    }
                    if (menor > 52 || contem(menor, princesa, princepe)) {
                        saida.write("-1\n");
                    } else {
                        saida.write(menor + "\n");
                    }
                } //1 de 3
                else if ((vence[0] == 3 && vence[1] != 3)
                        || (vence[0] != 3 && vence[1] == 3)) {
                    int menor = princesa[2];
                    menor++;
                    while (menor < 52 && contem(menor, princesa, princepe)) {
                        menor++;
                    }
                    if (menor > 52 || contem(menor, princesa, princepe)) {
                        saida.write("-1\n");
                    } else {
                        saida.write(menor + "\n");
                    }
                }
            }
            linha = entrada.readLine();
            leitura(linha, princesa, princepe);
        }
        saida.flush();
    }

    public static void leitura(String linha, int[] princesa, int[] princepe) throws NumberFormatException {
        String vet[] = linha.split(" ");
        for (int i = 0; i < 3; i++) {
            String carta = vet[i];
            int tmp = Integer.parseInt(carta);
            princesa[i] = tmp;
        }
        for (int i = 3; i < 5; i++) {
            String carta = vet[i];
            int tmp = Integer.parseInt(carta);
            princepe[i - 3] = tmp;
        }
    }

    public static boolean continua(int[] princesa, int[] princepe) {
        for (int q : princepe) {
            if (q != 0) {
                return true;
            }
        }
        for (int q : princesa) {
            if (q != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean contem(int valor, int[] princesa, int[] princepe) {
        for (int q : princepe) {
            if (q == valor) {
                return true;
            }
        }
        for (int q : princesa) {
            if (q == valor) {
                return true;
            }
        }
        return false;
    }

}

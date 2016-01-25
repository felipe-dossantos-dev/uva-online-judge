package ds.bitset;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Scanner;

public class UVA11926 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int oneTime = entrada.nextInt();
        int repeat = entrada.nextInt();
        while (oneTime != 0 || repeat != 0) {
            int ones[][] = new int[oneTime][2];
            for (int i = 0; i < oneTime; i++) {
                ones[i][0] = entrada.nextInt();
                ones[i][1] = entrada.nextInt();
            }
            int reps[][] = new int[repeat][3];
            for (int i = 0; i < repeat; i++) {
                reps[i][0] = entrada.nextInt();
                reps[i][1] = entrada.nextInt();
                reps[i][2] = entrada.nextInt();
            }
            boolean conflict = false;
            boolean array[] = new boolean[1000001];
            for (int i = 0; i < oneTime && !conflict; i++) {
                int ini = ones[i][0];
                int fim = ones[i][1];
                for (int j = ini; j < fim; j++) {
                    if (array[j]) {
                        conflict = true;
                        break;
                    }
                    array[j] = true;
                }
            }
            for (int i = 0; i < repeat && !conflict; i++) {
                int ini = reps[i][0];
                int fim = reps[i][1];
                int rep = reps[i][2];
                int dif = fim - ini;
                for (int j = ini; j < 1000000; j += rep) {
                    for (int k = j; k < j + dif && k < 1000000; k++) {
                        if (array[k]) {
                            conflict = true;
                            break;
                        }
                        array[k] = true;
                    }
                }
            }
            if (conflict) {
                saida.write("CONFLICT\n");
            } else {
                saida.write("NO CONFLICT\n");
            }
            oneTime = entrada.nextInt();
            repeat = entrada.nextInt();
        }
        saida.flush();
    }
}

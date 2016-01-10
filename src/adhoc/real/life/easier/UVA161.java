package adhoc.real.life.easier;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UVA161 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> lista = new ArrayList<>();
        while (entrada.hasNextInt()) {
            int tmp = entrada.nextInt();
            lista.add(tmp);
        }

        int pos = 0;
        while (lista.get(pos) != 0 || lista.get(pos + 1) != 0 || lista.get(pos + 2) != 0) {
            List<Integer> turno = new ArrayList<>();
            List<Integer> turno2 = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            while (lista.get(pos) != 0) {
                int tmp = lista.get(pos);
                min = Math.min(tmp, min);
                turno.add(tmp - 5);
                turno2.add(tmp * 2);
                pos++;
            }
            boolean achou = false;
            min = 2 * min;
            int sec = min;
            for (int i = min; i <= 18000 && !achou; i += min) {
                for (int k = i; k < i + min / 2 && !achou; k++) {
                    boolean vermelho = false;
                    for (int j = 0; j < turno.size(); j++) {
                        int atual = turno2.get(j);
                        if (k % atual >= turno.get(j)) {
                            vermelho = true;
                            break;
                        }
                    }
                    if (!vermelho) {
                        achou = true;
                    }
                    sec = k;
                }
            }
            if (achou && sec <= 18000) {
                saida.write(String.format("%02d:%02d:%02d\n", sec / 3600, sec / 60 % 60, sec % 60));
            } else {
                saida.write("Signals fail to synchronise in 5 hours\n");
            }
            pos++;
        }
        saida.flush();
    }
}

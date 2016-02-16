package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA11742 {

    public static List<Integer[]> constraints;
    public static int count;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        int sizeGroup = Integer.parseInt(vet[0]);// 0 <= n <= 8
        int numberConstraints = Integer.parseInt(vet[1]); // 0 <= n <= 20
        while (sizeGroup != 0 || numberConstraints != 0) {
            int array[] = new int[sizeGroup];
            constraints = new ArrayList<>();
            count = 0;
            for (int i = 0; i < sizeGroup; i++) {
                array[i] = i;
            }
            for (int i = 0; i < numberConstraints; i++) {
                linha = entrada.readLine();
                vet = linha.split("\\s+");
                int a = Integer.parseInt(vet[0]);
                int b = Integer.parseInt(vet[1]);
                int c = Integer.parseInt(vet[2]);
                Integer arr[] = {a, b, c};
                constraints.add(arr);
            }
            permutacao(array, 0);
            saida.write(count + "\n");
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            sizeGroup = Integer.parseInt(vet[0]);
            numberConstraints = Integer.parseInt(vet[1]);
        }
        saida.flush();
    }

    public static void permutacao(int[] array, int k) {
        for (int j = k; j < array.length; j++) {
            troca(array, j, k);
            permutacao(array, k + 1);
            troca(array, k, j);
        }
        //conferir constraints
        if (k + 1 == array.length) {
            boolean flag = true;
            int m;
            for (m = 0; m < constraints.size(); m++) {
                Integer[] constraint = constraints.get(m);
                int a = constraint[0];
                int b = constraint[1];
                int dist = constraint[2];
                //achar a posicao de a e de b
                //e ver se esta esta dentro da constraint
                int posA = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == a) {
                        posA = i;
                        break;
                    }
                }
                int posB = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == b) {
                        posB = i;
                        break;
                    }
                }
                if (dist > 0 && Math.abs(posA - posB) > dist) {
                    flag = false;
                    break;
                } else if (dist < 0 && Math.abs(posA - posB) < -dist) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
    }

    public static void troca(int[] array, int k, int i) {
        int tmp = array[k];
        array[k] = array[i];
        array[i] = tmp;
    }
}

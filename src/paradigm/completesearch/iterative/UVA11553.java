package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA11553 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        List<List<int[]>> perms = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            int arr[] = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = j;
            }
            perms.add(permutations(arr));
        }
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            int size = Integer.parseInt(linha);
            int matriz[][] = new int[size][size];
            for (int j = 0; j < size; j++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                for (int k = 0; k < size; k++) {
                    int tmp = Integer.parseInt(vet[k]);
                    matriz[j][k] = tmp;
                }
            }
            List<int[]> perm = perms.get(size - 1);
            int min = Integer.MAX_VALUE;
            for (int[] p1 : perm) {
                int soma = 0;
                for (int j = 0; j < p1.length; j++) {
                    soma += matriz[p1[j]][j];
                }
                min = Math.min(min, soma);
            }
            saida.write(min + "\n");
        }
        saida.flush();
    }

    static ArrayList<int[]> permutations(int[] a) {
        ArrayList<int[]> ret = new ArrayList<>();
        permutation(a, 0, ret);
        return ret;
    }

    public static void permutation(int[] arr, int pos, ArrayList<int[]> list) {
        if (arr.length - pos == 1) {
            list.add(arr.clone());
        } else {
            for (int i = pos; i < arr.length; i++) {
                swap(arr, pos, i);
                permutation(arr, pos + 1, list);
                swap(arr, pos, i);
            }
        }
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int h = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = h;
    }
}

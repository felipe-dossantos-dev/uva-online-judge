package paradigm.completesearch.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UVA624 {

    public static List<Integer> resp = new ArrayList<>();
    public static int max = 0, n;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            resp.clear();
            max = 0;
            String vet[] = linha.split("\\s+");
            n = Integer.parseInt(vet[0]);
            int numTracks = Integer.parseInt(vet[1]);
            int arr[] = new int[numTracks];
            for (int i = 0; i < numTracks; i++) {
                int tmp = Integer.parseInt(vet[i + 2]);
                arr[i] = tmp;
            }
            for (int i = 0; i < arr.length; i++) {
                backtrack(arr, i, 0, new ArrayList<>());
            }
            for (Integer l : resp) {
                saida.write(l + " ");
            }
            saida.write("sum:" + max + "\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }

    private static void backtrack(int[] arr, int pos, int sum, List<Integer> lista) {
        if (sum <= n) {

            List<Integer> nova = new ArrayList<>();
            nova.addAll(lista);
            nova.add(arr[pos]);

            int val = sum + arr[pos];
            if (val > max && val <= n) {
                max = val;
                resp = nova;
            }

            for (int i = pos + 1; i < arr.length; i++) {
                backtrack(arr, i, val, nova);
            }
        }
    }
}

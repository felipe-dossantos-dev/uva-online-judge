package ds.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12356 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        while (!linha.contains("0 0")) {
            String vet[] = linha.split("\\s+");
            int sols = Integer.parseInt(vet[0]);
            int reps = Integer.parseInt(vet[1]);
            int lefts[] = new int[sols + 2];
            int rights[] = new int[sols + 2];
            for (int i = 1; i <= sols; i++) {
                lefts[i] = i - 1;
                rights[i] = i + 1;
            }
            rights[sols] = 0;
            for (int i = 0; i < reps; i++) {
                linha = entrada.readLine();
                vet = linha.split("\\s+");
                int left = Integer.parseInt(vet[0]);
                int right = Integer.parseInt(vet[1]);
                lefts[rights[right]] = lefts[left];
                rights[lefts[left]] = rights[right];
                if (lefts[left] > 0) {
                    saida.write(lefts[left] + " ");
                } else {
                    saida.write("* ");
                }
                if (rights[right] < 1 || rights[right] > sols) {
                    saida.write("*\n");
                } else {
                    saida.write(rights[right] + "\n");
                }
            }
            saida.write("-\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

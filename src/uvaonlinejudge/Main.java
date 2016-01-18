package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(new FileInputStream(args[0]));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
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
                for (int j = left; j <= right; j++) {
                    lefts[j] = lefts[j - 1];
                }
                for (int j = right; j > left; j--) {
                    rights[j] = rights[j + 1];
                }
                if (lefts[left] < 1 || lefts[left] > sols) {
                    saida.write("* ");
                } else {
                    saida.write(lefts[left] + " ");
                }
                if (rights[right] < 1 || rights[right] > sols) {
                    saida.write("*\n");
                } else{
                    saida.write(rights[right] + "\n");
                }
            }
            saida.write("-\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

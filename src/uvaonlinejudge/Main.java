package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int a = Integer.parseInt(vet[0]);
        int b = Integer.parseInt(vet[1]);
        boolean cartas[] = new boolean[100005];
        boolean red[] = new boolean[100005];
        int repetidas = 0;
        int distintas = 0;
        while (a != 0 && b != 0) {
            linha = entrada.readLine();
            vet = linha.split(" ");
            int trocas = 0;
            for (String str : vet) {
                int pos = Integer.parseInt(str);
                if (!cartas[pos]) {
                    cartas[pos] = true;
                    distintas++;
                }
            }

            linha = entrada.readLine();
            vet = linha.split(" ");
            for (String str : vet) {
                int pos = Integer.parseInt(str);
                if (!cartas[pos]) {
                    trocas++;
                    cartas[pos] = true;
                } else if (!red[pos]){
                    red[pos] = true;
                    repetidas++;
                }
            }
            
            saida.write(trocas + "\n");
            linha = entrada.readLine();
            vet = linha.split(" ");
            a = Integer.parseInt(vet[0]);
            b = Integer.parseInt(vet[1]);
            Arrays.fill(cartas, false);
            Arrays.fill(red, false);
        }
        saida.flush();
    }
}

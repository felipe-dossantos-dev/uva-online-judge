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
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int numeroBancos = Integer.parseInt(vet[0]);
        int numeroDebentures = Integer.parseInt(vet[1]);
        while (numeroBancos != 0 && numeroDebentures != 0) {
            linha = entrada.readLine();
            vet = linha.split(" ");
            int saldos[] = new int[numeroBancos];
            for (int i = 0; i < numeroBancos; i++) {
                int tmp = Integer.parseInt(vet[i]);
                saldos[i] = tmp;
            }
            for (int i = 0; i < numeroDebentures; i++) {
                linha = entrada.readLine();
                vet = linha.split(" ");
                int cre = Integer.parseInt(vet[0]) - 1;
                int deb = Integer.parseInt(vet[1]) - 1;
                int valor = Integer.parseInt(vet[2]);
                saldos[deb] += valor;
                saldos[cre] -= valor;
            }
            boolean estouro = false;
            for (int i = 0; i < numeroBancos && !estouro; i++) {
                if (saldos[i] < 0) estouro = true;
            }
            if (estouro) {
                saida.write("N");
            } else {
                saida.write("S");
            }
            saida.newLine();
            linha = entrada.readLine();
            vet = linha.split(" ");
            numeroBancos = Integer.parseInt(vet[0]);
            numeroDebentures = Integer.parseInt(vet[1]);
        }
        saida.flush();
    }
}

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

    public static int MATRIX_MAX = 25;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));C:\\Users\\felipe.santos\\Documents\\
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
//        String linha = entrada.readLine();
        for (int i = 1; i <= 1997; i++) {
            for (int j = i; j <= 1997 - i; j++) {
                for (int k = j; k <= 1997 - i - j; k++) {
                    int d = 2000 - i - j - k;
                    double a = (i / 100.0);
                    double b = (j / 100.0);
                    double c = (k / 100.0);
                    double e = d / 100.0;
                    if (a * b * c * e == 20.0) {
                        saida.write(String.format("%.2f %.2f %.2f %.2f\n", a, b, c, e));
                    }
                }
            }
        }
        saida.flush();
    }
}

package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(new FileInputStream(args[0]));
//        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        while (!linha.equals("0:00")) {
            String vet[] = linha.split(":");
            int horas = Integer.parseInt(vet[0]); // 30 por hora + 0.5 por minutos
            int minutos = Integer.parseInt(vet[1]); // 6 por minutos
            
            double grauHoras = 30 * horas + 0.5 * minutos;
            double grauMin = 6 * minutos;
            grauHoras = grauHoras % 360;
            
            double res = Math.abs(grauHoras - grauMin);
            if (res > 180.0) {
                res = 360 - res;
            }
            saida.write(String.format("%.3f\n", res));
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

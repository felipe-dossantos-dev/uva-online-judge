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
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(new FileInputStream(args[0]));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
        String linha = entrada.readLine();
        char pag[][] = new char[60][60];
        for (int i = 0; i < 60; i++) {
            Arrays.fill(pag[i], '.');
        }
        while (!linha.equals(".EOP")) {
            
            
            linha = entrada.readLine();
        }
        //printar pagina
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                saida.write(pag[i][j]);
            }
            saida.write("\n");
        }
        saida.write("\n");
        for (int i = 0; i < 60; i++) {
            saida.write('.');
        }
        saida.write("\n");
        saida.flush();
    }
}

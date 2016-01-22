package uvaonlinejudge;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(new FileInputStream(args[0]));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        int computers = entrada.nextInt();
        int caso = 1;
        BitSet bs = new BitSet(10005);
        //700
        while (computers != 0){
            boolean unknown = true;
            for (int i = 0; i < computers; i++) {
                int appear = entrada.nextInt();
                int insteadOfFirstYear = entrada.nextInt();
                int firstYearBug = entrada.nextInt();
             
            }
            saida.write("Case #" + caso + ":\n");
            saida.write("The actual year is 2141.");
            saida.write("Unknown bugs detected.");
            caso++;
            computers = entrada.nextInt();
        }
        saida.flush();
    }
}

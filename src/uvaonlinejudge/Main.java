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

    private static int surplus;
    private static int deficit;
    private static int max;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));//C:\Users\felipe.santos\Documents\
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        linha = entrada.readLine();
        while (!linha.contains("0000")) {
            String vet[] = linha.split("\\s+");
            
            
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

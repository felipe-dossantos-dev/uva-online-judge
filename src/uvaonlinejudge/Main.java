package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
        int caso = Integer.parseInt(entrada.readLine());
        while (caso != -1) {
            String palavra = entrada.readLine();
            String palpite = entrada.readLine();
            List<Character> lista = new ArrayList<>();
            for (int i = 0; i < palavra.length(); i++) {
                char p = palavra.charAt(i);
                lista.add(p);
            }
            int flag = 0;
            for (int i = 0; i < palpite.length(); i++) {
                if (lista.isEmpty()) {
                    int size = lista.size();
                    lista.remove(palpite.charAt(i));
                }
            }
            caso = Integer.parseInt(entrada.readLine());
        }
        saida.flush();
    }
}

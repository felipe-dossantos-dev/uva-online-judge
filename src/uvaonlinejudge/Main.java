package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String source = entrada.readLine();
        if (source.isEmpty()) {
            source = entrada.readLine();
        }
        String target = entrada.readLine();
        if (target.isEmpty()) {
            source = entrada.readLine();
        }
        while (source != null && target != null) {
            saida.write("[\n");
            Stack<Character> pilha = new Stack<>();
            Map<Character, Integer> mapa1 = countLetras(source);
            Map<Character, Integer> mapa2 = countLetras(target);
            if (mapa1.equals(mapa2)){
                saida.write("iguais");
            } 
            saida.write("]\n");
            source = entrada.readLine();
            if (source != null && source.isEmpty()) {
                source = entrada.readLine();
            }
            target = entrada.readLine();
            if (target != null && target.isEmpty()) {
                source = entrada.readLine();
            }
        }
        saida.flush();
    }

    public static Map<Character, Integer> countLetras(String str) {
        Map<Character, Integer> mapa1 = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (mapa1.containsKey(c)) {
                mapa1.put(c, mapa1.get(c) + 1);
            } else {
                mapa1.put(c, 1);
            }
        }
        return mapa1;
    }

}

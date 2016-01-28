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
            Map<Character, Integer> mapa1 = countLetras(source);
            Map<Character, Integer> mapa2 = countLetras(target);
            if (mapa1.equals(mapa2)) {
                backtrack(saida, source, target, "", "", "", 0, 0);
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

    public static void backtrack(BufferedWriter saida, String source,
            String target, String pilha,
            String atual, String io, int pops, int pushs) throws IOException {
        System.out.println(source + " " + pilha + " " + atual + " " + io);
        if (atual.contains(target)) {
            saida.write(io + "\n");
        } else {
            //i
            if (!source.isEmpty()) {
                String pLetraSource = source.substring(0, 1);
                String restoSource = source.substring(1, source.length());

                pilha = pilha.concat(pLetraSource);

                String novoIo = "";
                if (!io.isEmpty()) {
                    novoIo = io.concat(" ");
                }
                novoIo = novoIo.concat("i");

                backtrack(saida, restoSource, target, pilha, atual, novoIo, pops, pushs + 1);
            }
            //o
            if (pops < pushs) {
                String outPilha = pilha.substring(pilha.length() - 1, pilha.length());
                String novaPilha = pilha.substring(0, pilha.length() - 1);

                String novoAtual = atual.concat(outPilha);

                String novoIo = "";
                if (!io.isEmpty()) {
                    novoIo = io.concat(" ");
                }
                novoIo = novoIo.concat("o");
                
                backtrack(saida, source, target, novaPilha, novoAtual, novoIo, pops + 1, pushs);
            }
        }
    }

}

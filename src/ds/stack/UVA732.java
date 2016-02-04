package ds.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Está versão não está funcionando, até conseguir fazer, mas deu TLE
 *
 * @author felipe.santos
 */
public class UVA732 {

    public static Set<String> conj;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
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
            conj = new HashSet<>();
            if (mapa1.equals(mapa2)) {
                List<Character> lSource = new ArrayList<>();
                for (int i = 0; i < source.length(); i++) {
                    lSource.add(source.charAt(i));
                }
                backtrack(lSource, target, new Stack<Character>(), new ArrayList<Character>(), "", 0, 0);
            }
            for (String conj1 : conj) {
                saida.write(conj1 + "\n");
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

    public static void backtrack(List<Character> source,
            String target, Stack<Character> pilha,
            List<Character> atual, String io, int pops, int pushs) throws IOException {
        boolean equal = true;
        for (int i = 0; i < atual.size(); i++) {
            if (!atual.get(i).equals(target.charAt(i))) {
                equal = false;
            }
        }
        if (equal && atual.size() == target.length()) {
            conj.add(io);
        } else {
            //i
            if (!source.isEmpty()) {
                Character pLetraSource = source.remove(0);

                pilha.push(pLetraSource);

                String novoIo = "";
                if (!io.isEmpty()) {
                    novoIo = io.concat(" ");
                }
                novoIo = novoIo.concat("i");
                Stack<Character> novaP = (Stack<Character>) pilha.clone();
                backtrack(new ArrayList<Character>(source), target, novaP, new ArrayList<Character>(atual), novoIo, pops, ++pushs);
                io = novoIo;
            }
            //o
            if (pops < pushs) {
                Character outPilha = pilha.pop();

                atual.add(outPilha);

                String novoIo = "";
                if (!io.isEmpty()) {
                    novoIo = io.concat(" ");
                }
                novoIo = novoIo.concat("o");
                Stack<Character> novaP = (Stack<Character>) pilha.clone();
                backtrack(new ArrayList<Character>(source), target, novaP, new ArrayList<Character>(atual), novoIo, ++pops, pushs);
            }
        }
    }
}

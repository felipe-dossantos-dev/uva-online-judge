package ds.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class UVA1062 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int caso = 1;
        while (!linha.equals("end")) {
            List<Stack<Character>> lista = new ArrayList<>();
            for (char c : linha.toCharArray()) {
                int dif = Integer.MAX_VALUE;
                int pos = -1;
                for (int i = 0; i < lista.size(); i++) {
                    Stack<Character> pilha = lista.get(i);
                    Character topo = pilha.peek();
                    if (c <= topo && topo - c < dif) {
                        dif = c - topo;
                        pos = i;
                    }
                }
                if (pos == -1) {
                    Stack<Character> nova = new Stack<>();
                    nova.push(c);
                    lista.add(nova);
                } else {
                    lista.get(pos).add(c);
                }
            }
            saida.write("Case " + caso + ": " + (lista.isEmpty() ? 1 : lista.size()) + "\n");
            caso++;
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

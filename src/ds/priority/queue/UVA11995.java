package ds.priority.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Stack;

public class UVA11995 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            int qtdEntradas = Integer.parseInt(linha);
            List<Integer> lista = new ArrayList<>(1005);
            Stack<Integer> pilha = new Stack<>();
            PriorityQueue<Integer> prioridade = new PriorityQueue<>(1005, Collections.reverseOrder());
            boolean ehLista = true;
            boolean ehPilha = true;
            boolean ehPrioridade = true;
            for (int i = 0; i < qtdEntradas; i++) {
                linha = entrada.readLine();
                String vet[] = linha.split("\\s+");
                int operacao = Integer.parseInt(vet[0]);
                int valor = Integer.parseInt(vet[1]);
                if (operacao == 1) {
                    //entrada
                    if (ehLista) {
                        lista.add(valor);
                    }
                    if (ehPilha) {
                        pilha.push(valor);
                    }
                    if (ehPrioridade) {
                        prioridade.add(valor);
                    }
                } else if (operacao == 2) {
                    //saida
                    if (ehLista && !lista.isEmpty()) {
                        ehLista = lista.remove(0) == valor;
                    } else {
                        ehLista = false;
                    }
                    if (ehPilha && !pilha.isEmpty()) {
                        ehPilha = pilha.pop() == valor;
                    } else {
                        ehPilha = false;
                    }
                    if (ehPrioridade && !prioridade.isEmpty()) {
                        ehPrioridade = prioridade.poll() == valor;
                    } else {
                        ehPrioridade = false;
                    }
                }
            }
            if (!ehLista && !ehPilha && !ehPrioridade) {
                saida.write("impossible");
            } else if ((ehLista && ehPilha)
                    || (ehPilha && ehPrioridade)
                    || (ehLista && ehPrioridade)) {
                saida.write("not sure");
            } else if (ehLista) {
                saida.write("queue");
            } else if (ehPilha) {
                saida.write("stack");
            } else if (ehPrioridade) {
                saida.write("priority queue");
            }
            saida.write("\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

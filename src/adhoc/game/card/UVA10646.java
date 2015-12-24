package adhoc.game.card;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Locale;
import java.util.Stack;

public class UVA10646 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            String cartas[] = linha.split(" ");
            int y = 0;
            Stack<String> pilha = new Stack<>();
            Stack<String> mao = new Stack<>();
            for (String carta : cartas) {
                pilha.push(carta);
            }
            for (int j = 0; j < 25; j++) {
                String carta = pilha.pop();
                mao.push(carta);
            }
            for (int j = 0; j < 3; j++) {
                String carta = pilha.pop();
                int valor = determinarValor(carta);
                y += valor;
                for (int k = 0; k < 10 - valor; k++) {
                    pilha.pop();
                }
            }
            Collections.reverse(mao);
            pilha.addAll(mao);
            while (pilha.size() != y) {
                pilha.pop();
            }
            String carta = pilha.pop();
            saida.write("Case " + (i + 1) + ": " + carta + "\n");
        }
        saida.flush();
    }

    private static int determinarValor(String carta) {
        int valor = carta.charAt(0) - '0';
        if (valor < 2 || valor > 9) {
            valor = 10;
        }
        return valor;

    }
}

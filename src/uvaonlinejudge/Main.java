package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Locale;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        while (!linha.equals("#")) {
            Stack<String> dealer = new Stack<>();
            Stack<String> nonDealer = new Stack<>();
            Stack<String> heap = new Stack<>();
            boolean turn = false;
            //entrada
            for (int i = 0; i < 4; i++) {
                String vet[] = linha.split(" ");
                for (String card : vet) {
                    if (turn) {
                        dealer.push(card);
                    } else {
                        nonDealer.push(card);
                    }
                    turn = !turn;
                }
                linha = entrada.readLine();
            }
            //logica
            String actualCard;
            int face = 0;
            while (!isOver(dealer, nonDealer, turn)) {
                actualCard = nextCard(turn, dealer, nonDealer);
                heap.add(actualCard);
                int valor = faceCard(actualCard);
                if (valor > 0) {
                    face = valor;
                    turn = !turn;
                } else if (face > 0) {
                    face--;
                    if (face == 0) {
                        turn = !turn;
                        Collections.reverse(heap);
                        if (turn) {
                            dealer.addAll(0, heap);
                        } else {
                            nonDealer.addAll(0, heap);
                        }
                        heap.clear();
                    } else if (dealer.isEmpty() && nonDealer.isEmpty()) {
                        turn = !turn;
                        Collections.reverse(heap);
                        if (turn) {
                            dealer.addAll(0, heap);
                        } else {
                            nonDealer.addAll(0, heap);
                        }
                    }
                } else {
                    turn = !turn;
                }
            }
            if (dealer.size() > 0 || !turn) {
                saida.write(String.format("1%3d", dealer.size()));
            } else {
                saida.write(String.format("2%3d", nonDealer.size()));
            }
            saida.newLine();
        }
        saida.flush();
    }

    public static String nextCard(boolean turn, Stack<String> dealer, Stack<String> nonDealer) {
        String lastCard;
        if (turn) {
            lastCard = dealer.pop();
        } else {
            lastCard = nonDealer.pop();
        }
        return lastCard;
    }

    public static int faceCard(String card) {
        if (card.contains("A")) {
            return 4;
        } else if (card.contains("K")) {
            return 3;
        } else if (card.contains("Q")) {
            return 2;
        } else if (card.contains("J")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean isOver(Stack<String> dealer, Stack<String> nonDealer, boolean turn) {
        if (turn) {
            return dealer.isEmpty();
        } else {
            return nonDealer.isEmpty();
        }
    }
}

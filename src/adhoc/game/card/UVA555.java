package adhoc.game.card;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class UVA555 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (!linha.equals("#")) {
            String dealer = linha;
            String primParte = entrada.readLine();
            String segParte = entrada.readLine();
            Carta maos[][] = new Carta[4][13];
            int posMao = -1;
            int primeiro = 0;
            if (dealer.equals("N")) {
                posMao = 2;
                primeiro = 2;
            } else if (dealer.equals("E")) {
                posMao = 3;
                primeiro = 3;
            } else if (dealer.equals("S")) {
                posMao = 0;
                primeiro = 0;
            } else if (dealer.equals("W")) {
                posMao = 1;
                primeiro = 1;
            }
            int posCarta = 0;
            for (int i = 0; i < primParte.length(); i += 2) {
                Carta c = lerCarta(primParte.charAt(i), primParte.charAt(i + 1));
                maos[posMao][posCarta] = c;
                posMao++;
                posMao = posMao % 4;
                if (posMao == primeiro) {
                    posCarta++;
                }
            }

            for (int i = 0; i < segParte.length(); i += 2) {
                Carta c = lerCarta(segParte.charAt(i), segParte.charAt(i + 1));
                maos[posMao][posCarta] = c;
                posMao++;
                posMao = posMao % 4;
                if (posMao == primeiro) {
                    posCarta++;
                }
            }
            Carta s[] = maos[3];
            Arrays.sort(s);
            Carta w[] = maos[0];
            Arrays.sort(w);
            Carta n[] = maos[1];
            Arrays.sort(n);
            Carta e[] = maos[2];
            Arrays.sort(e);
            saida.write("S: ");
            for (int i = 0; i < s.length; i++) {
                Carta s1 = s[i];
                saida.write(s1.toString());
                if (i != 12) {
                    saida.write(" ");
                } else {
                    saida.write("\n");
                }
            }
            saida.write("W: ");
            for (int i = 0; i < w.length; i++) {
                Carta s1 = w[i];
                saida.write(s1.toString());
                if (i != 12) {
                    saida.write(" ");
                } else {
                    saida.write("\n");
                }
            }
            saida.write("N: ");
            for (int i = 0; i < n.length; i++) {
                Carta s1 = n[i];
                saida.write(s1.toString());
                if (i != 12) {
                    saida.write(" ");
                } else {
                    saida.write("\n");
                }
            }
            saida.write("E: ");
            for (int i = 0; i < e.length; i++) {
                Carta s1 = e[i];
                saida.write(s1.toString());
                if (i != 12) {
                    saida.write(" ");
                } else {
                    saida.write("\n");
                }
            }
            linha = entrada.readLine();
        }
        saida.flush();
    }

    public static class Carta implements Comparable<Carta> {

        public char suit;
        public int valor;
        public int valorSuit;

        public Carta() {
        }

        @Override
        public String toString() {
            String ret = "" + suit;
            if (this.valor == 14) {
                ret += "A";
            } else if (this.valor == 13) {
                ret += "K";
            } else if (this.valor == 12) {
                ret += "Q";
            } else if (this.valor == 11) {
                ret += "J";
            } else if (this.valor == 10) {
                ret += "T";
            } else {
                ret += "" + valor;
            }
            return ret;
        }

        @Override
        public int compareTo(Carta c) {
            if (valorSuit < c.valorSuit) {
                return -1;
            }
            if (valorSuit > c.valorSuit) {
                return 1;
            }
            if (valor < c.valor) {
                return -1;
            }
            if (valor > c.valor) {
                return 1;
            }
            return 0;
        }
    }

    public static Carta lerCarta(char suit, char valor) {
        Carta c = new Carta();
        c.suit = suit;
        if (suit == 'C') {
            c.valorSuit = 0;
        }
        if (suit == 'D') {
            c.valorSuit = 1;
        }
        if (suit == 'S') {
            c.valorSuit = 2;
        }
        if (suit == 'H') {
            c.valorSuit = 3;
        }
        if (valor == 'A') {
            c.valor = 14;
        } else if (valor == 'K') {
            c.valor = 13;
        } else if (valor == 'Q') {
            c.valor = 12;
        } else if (valor == 'J') {
            c.valor = 11;
        } else if (valor == 'T') {
            c.valor = 10;
        } else {
            c.valor = valor - '0';
        }
        return c;
    }
}

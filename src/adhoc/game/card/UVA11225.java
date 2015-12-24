package adhoc.game.card;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11225 {

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
            int qtdCartas = Integer.parseInt(linha);
            double pontos = 0;
            int oudlers = 0;
            for (int j = 0; j < qtdCartas; j++) {
                linha = entrada.readLine();
                double valor = numeroPontos(linha);
                oudlers += contaOudler(linha);
                pontos += valor;
            }
            //qtd de oudlers influencia na qtd de pontos
            int metaPontos = metaPontos(oudlers);
            pontos = metaPontos - pontos;
            saida.write("Hand #" + (i + 1) + "\n");
            if (pontos <= 0) {
                int val = -(int) pontos;
                String ret = String.format("Game won by %d point(s).\n", val);
                saida.write(ret);
            } else {
                int val = (int) pontos;
                String ret = String.format("Game lost by %d point(s).\n", val);
                saida.write(ret);
            }
            if (i != qtdTestes - 1) {
                saida.write("\n");
            }
        }
        saida.flush();
    }

    private static double numeroPontos(String linha) {
        if (contaOudler(linha) == 1 || linha.contains("king")) {
            return 4.5;
        }
        if (linha.contains("queen")) {
            return 3.5;
        }
        if (linha.contains("knight")) {
            return 2.5;
        }
        if (linha.contains("jack")) {
            return 1.5;
        }
        return 0.5;
    }

    public static int contaOudler(String linha) {
        if (linha.contains("one of trumps")
                || linha.contains("twenty-one of trumps")
                || linha.contains("fool")) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int metaPontos(int oudlers) {
        if (oudlers == 1) {
            return 51;
        }
        if (oudlers == 2) {
            return 41;
        }
        if (oudlers == 3) {
            return 36;
        }
        return 56;
    }
}

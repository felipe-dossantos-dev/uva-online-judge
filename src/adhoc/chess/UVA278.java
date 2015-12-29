package adhoc.chess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA278 {

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
            String vet[] = linha.split(" ");
            int rows = Integer.parseInt(vet[1]);
            int collumns = Integer.parseInt(vet[2]);
            int ret = 0;
            if (vet[0].equalsIgnoreCase("r")) {
                ret = rooks(rows, collumns);
            } else if (vet[0].equals("k")) {
                ret = knights(rows, collumns);
            } else if (vet[0].equalsIgnoreCase("Q")) {
                ret = queens(rows, collumns);
            } else if (vet[0].equals("K")) {
                ret = kings(rows, collumns);
            }
            saida.write(ret + "\n");
        }
        saida.flush();
    }

    private static int rooks(int rows, int collumns) {
        return Math.min(rows, collumns);
    }

    private static int queens(int rows, int collumns) {
        return Math.min(rows, collumns);
    }

    private static int kings(int rows, int collumns) {
        rows += rows % 2 == 1 ? 1 : 0;
        collumns += collumns % 2 == 1 ? 1 : 0;
        return rows * collumns / 4;
    }

    private static int knights(int rows, int collumns) {
        int tot = rows * collumns;
        return (tot + 1) / 2;
    }
}

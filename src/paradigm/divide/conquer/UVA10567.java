package paradigm.divide.conquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class UVA10567 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));///home/felipe/
//        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));;
        List<List<Integer>> listas = new ArrayList<>();
        for (int i = 0; i < 65; i++) {
            listas.add(new ArrayList<>());
        }

        String linha = entrada.readLine();
        for (int i = 0; i < linha.length(); i++) {
            char c = linha.charAt(i);
            List<Integer> lista = listas.get(mapLetterToIndex(c));
            lista.add(i);
        }

        linha = entrada.readLine();
        int q = Integer.parseInt(linha);
        for (int i = 0; i < q; i++) {

            linha = entrada.readLine();

            boolean ok = true;
            int first = 0;
            int last = -1;

            for (int j = 0; j < linha.length(); j++) {

                char c = linha.charAt(j);
                List<Integer> lista = listas.get(mapLetterToIndex(c));
                int idx = Collections.binarySearch(lista, last + 1);

                if (idx < 0) {
                    int insert_idx = -(idx + 1);
                    if (insert_idx >= lista.size()) {
                        ok = false;
                        break;
                    }
                    last = lista.get(insert_idx);
                } else {
                    last = lista.get(idx);
                }

                if (j == 0) {
                    first = last;
                }

            }

            if (!ok) {
                saida.write("Not matched\n");
            } else {
                saida.write("Matched");
                saida.write(" " + first);
                saida.write(" " + last);
                saida.write("\n");
            }
        }

        saida.flush();
    }

    public static int mapLetterToIndex(char c) {
        return c - 'A';
    }
}

package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11586 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 0; i < qtdTestes; i++) {
            linha = entrada.readLine();
            int m = 0;
            int f = 0;
            for (char c : linha.toCharArray()) {
                if (c == 'M') {
                    m++;
                } else if (c == 'F') {
                    f++;
                }
            }
            if (m == f && m != 1) {
                saida.write("LOOP");
            } else {
                saida.write("NO LOOP");
            }
            saida.newLine();
        }
        saida.flush();
    }
}

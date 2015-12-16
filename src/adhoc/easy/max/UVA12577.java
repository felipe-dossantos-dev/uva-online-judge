package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12577 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int caso = 1;
        while (!linha.equals("*")) {
            saida.write("Case " + caso + ": ");
            if (linha.equals("Hajj")) {
                saida.write("Hajj-e-Akbar");
            } else {
                saida.write("Hajj-e-Asghar");
            }
            saida.newLine();
            caso++;
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

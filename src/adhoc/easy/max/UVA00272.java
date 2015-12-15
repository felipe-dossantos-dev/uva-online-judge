package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA00272 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        boolean primeira = true;
        while (linha != null) {
            String ret = "";
            for (char c : linha.toCharArray()) {
                if (c == '\"' && primeira) {
                    ret += "`";
                    ret += "`";
                    primeira = !primeira;
                } else if (c == '\"' && !primeira) {
                    ret += "'";
                    ret += "'";
                    primeira = !primeira;
                } else {
                    ret += c;
                }
            }
            saida.write(ret);
            linha = entrada.readLine();
            saida.newLine();
        }
        saida.flush();
    }
}

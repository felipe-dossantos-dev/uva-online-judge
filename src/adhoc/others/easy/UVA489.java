package adhoc.others.easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class UVA489 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int caso = Integer.parseInt(entrada.readLine());
        while (caso != -1) {
            String palavra = entrada.readLine();
            Set<Character> conjPalavra = new TreeSet<>();
            for (char toCharArray : palavra.toCharArray()) {
                conjPalavra.add(toCharArray);
            }

            String palpite = entrada.readLine();
            List<Character> conjPalpite = new ArrayList<>();
            for (char toCharArray : palpite.toCharArray()) {
                if (!conjPalpite.contains(toCharArray)) {
                    conjPalpite.add(toCharArray);
                }
            }

            int erros = 0;
            int acertos = 0;
            for (Character p : conjPalpite) {
                if (conjPalavra.contains(p)) {
                    acertos++;
                    if (acertos == conjPalavra.size()) {
                        break;
                    }
                } else {
                    erros++;
                    if (erros == 7) {
                        break;
                    }
                }
            }

            saida.write("Round " + caso + "\n");
            if (acertos == conjPalavra.size()) {
                saida.write("You win.\n");
            } else if (erros >= 7) {
                saida.write("You lose.\n");
            } else {
                saida.write("You chickened out.\n");
            }
            caso = Integer.parseInt(entrada.readLine());
        }
        saida.flush();
    }
}

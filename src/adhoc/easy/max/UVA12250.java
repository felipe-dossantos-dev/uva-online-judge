package adhoc.easy.max;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class UVA12250 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        Map<String, String> mapa = new HashMap<>();
        mapa.put("HELLO", "ENGLISH");
        mapa.put("HOLA", "SPANISH");
        mapa.put("HALLO", "GERMAN");
        mapa.put("BONJOUR", "FRENCH");
        mapa.put("CIAO", "ITALIAN");
        mapa.put("ZDRAVSTVUJTE", "RUSSIAN");
        int caso = 1;
        while (!linha.equals("#")) {
            saida.write("Case " + caso + ": ");
            if (mapa.containsKey(linha)) {
                saida.write(mapa.get(linha));
            } else {
                saida.write("UNKNOWN");
            }
            saida.newLine();
            caso++;
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

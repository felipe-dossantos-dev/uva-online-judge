package ds.set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class UVA978 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split("\n");
            int battlefield = Integer.parseInt(vet[0]);
            int greens = Integer.parseInt(vet[1]);
            int blues = Integer.parseInt(vet[2]);
            TreeMap<Integer, Integer> greenArmy = new TreeMap<>();
            TreeMap<Integer, Integer> blueArmy = new TreeMap<>();
            for (int j = 0; j < greens; j++) {
                linha = entrada.readLine();
                int lemming = Integer.parseInt(linha);
                if (greenArmy.containsKey(lemming)) {
                    greenArmy.put(lemming, greenArmy.get(lemming) + 1);
                } else {
                    greenArmy.put(lemming, 1);
                }
            }
            for (int j = 0; j < blues; j++) {
                linha = entrada.readLine();
                int lemming = Integer.parseInt(linha);
                if (blueArmy.containsKey(lemming)) {
                    blueArmy.put(lemming, blueArmy.get(lemming) + 1);
                } else {
                    blueArmy.put(lemming, 1);
                }
            }
            while (!greenArmy.isEmpty() && !blueArmy.isEmpty()) {
                for (int j = 0; j < battlefield && !greenArmy.isEmpty() && !blueArmy.isEmpty(); j++) {
                    Map.Entry<Integer, Integer> blue = blueArmy.lastEntry();
                    Map.Entry<Integer, Integer> green = greenArmy.lastEntry();
                }
            }
        }
        saida.flush();
    }
}

package ds.set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class UVA978 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int testes = Integer.parseInt(linha);
        for (int i = 0; i < testes; i++) {
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
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
                List<Integer> greenSide = new ArrayList<>();
                List<Integer> blueSide = new ArrayList<>();
                for (int j = 0; j < battlefield && !greenArmy.isEmpty() && !blueArmy.isEmpty(); j++) {
                    Map.Entry<Integer, Integer> blue = blueArmy.lastEntry();
                    Map.Entry<Integer, Integer> green = greenArmy.lastEntry();
                    blueSide.add(blue.getKey());
                    greenSide.add(green.getKey());
                    if (blue.getValue() == 1) {
                        blueArmy.remove(blue.getKey());
                    } else {
                        blueArmy.put(blue.getKey(), blue.getValue() - 1);
                    }
                    if (green.getValue() == 1) {
                        greenArmy.remove(green.getKey());
                    } else {
                        greenArmy.put(green.getKey(), green.getValue() - 1);
                    }
                }
                for (int j = 0; j < battlefield && !greenSide.isEmpty() && !blueSide.isEmpty(); j++) {
                    int blue = blueSide.remove(0);
                    int green = greenSide.remove(0);
                    if (blue > green) {
                        int dif = blue - green;
                        if (blueArmy.containsKey(dif)) {
                            blueArmy.put(dif, blueArmy.get(dif) + 1);
                        } else {
                            blueArmy.put(dif, 1);
                        }
                    } else if (blue < green) {
                        int dif = green - blue;
                        if (greenArmy.containsKey(dif)) {
                            greenArmy.put(dif, greenArmy.get(dif) + 1);
                        } else {
                            greenArmy.put(dif, 1);
                        }
                    }
                }
            }
            if (blueArmy.size() == 0 && greenArmy.size() == 0) {
                saida.write("green and blue died\n");
            } else if (blueArmy.size() > 0) {
                saida.write("blue wins\n");
                NavigableMap<Integer, Integer> a = blueArmy.descendingMap();
                for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
                    for (int j = 0; j < entry.getValue(); j++) {
                        saida.write(entry.getKey() + "\n");
                    }
                }
            } else if (greenArmy.size() > 0) {
                saida.write("green wins\n");
                NavigableMap<Integer, Integer> a = greenArmy.descendingMap();
                for (Map.Entry<Integer, Integer> entry : a.entrySet()) {
                    for (int j = 0; j < entry.getValue(); j++) {
                        saida.write(entry.getKey() + "\n");
                    }
                }
            }
            saida.write("\n");
        }
        saida.flush();
    }
}

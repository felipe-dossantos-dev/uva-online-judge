package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        TreeMap<String, Integer> mapa;
        String linha = entrada.readLine();
        int qtdLinhas = Integer.parseInt(linha);
        while (qtdLinhas != 0) {
            mapa = new TreeMap<>();
            List<String> entradas = new ArrayList<>(qtdLinhas);
            for (int i = 0; i < qtdLinhas; i++) {
                linha = entrada.readLine();
                entradas.add(linha);
                String vet[] = linha.split("\\s+");
                for (int j = 0; j < vet.length; j++) {
                    String str = vet[j];
                    if (mapa.containsKey(str)) {
                        mapa.put(str, mapa.get(str) + 1);
                    } else {
                        mapa.put(str, 1);
                    }
                }
            }
            //pegar os 5 maiores            
            List<String> listaTop = new ArrayList<>();
            List<Map.Entry<String, Integer>> listaT = new ArrayList<>(mapa.entrySet());
            Collections.sort(listaT, new Comparator<Map.Entry<String, Integer>>(){
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return -o1.getValue().compareTo(o2.getValue());
                }
            });
            
            //aqui que ta
            int cont = 0;
            int ant = listaT.get(0).getValue();
            for (Map.Entry<String, Integer> key : listaT) {
                if (ant != key.getValue() && cont >= 5) break;
                listaTop.add(key.getKey());
                cont++;
                ant = key.getValue();
            }
            
            int total = 0;
            for (String ent : entradas) {
                cont = 0;
                for (String top : listaTop) {
                    if (ent.contains(top)) {
                        cont++;
                    }
                }
                if (cont == 5) {
                    total++;
                }
            }
            saida.write(total + "\n");
            linha = entrada.readLine();
            qtdLinhas = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

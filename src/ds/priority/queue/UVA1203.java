package ds.priority.queue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA1203 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.nextLine();
        Map<Integer, List<Integer>> instructions = new HashMap<>();
        PriorityQueue<Integer> periods = new PriorityQueue<>(10000);
        while (!linha.contains("#")) {
            String vet[] = linha.split("\\s+");
            int time = Integer.parseInt(vet[2]);
            if (instructions.containsKey(time)) {
                List<Integer> qNums = instructions.get(time);
                qNums.add(Integer.parseInt(vet[1]));
                Collections.sort(qNums);
            } else {
                List<Integer> qNums = new ArrayList<>();
                qNums.add(Integer.parseInt(vet[1]));
                instructions.put(time, qNums);
            }
            if (!periods.contains(time)) {
                periods.add(time);
            }
            linha = entrada.nextLine();
        }
        int queries = entrada.nextInt();
        int actual = 1;
        List<Integer> resto = new ArrayList<>();
        List<Integer> ordem = new ArrayList<>();
        while (queries > 0) {
            while (!periods.isEmpty()) {
                int time = periods.poll();
                if (actual % time == 0) {
                    List<Integer> qNums = instructions.get(time);
                    ordem.addAll(qNums);
                }
                resto.add(time);
            }
            Collections.sort(ordem);
            for (Integer qNum : ordem) {
                queries--;
                saida.write(qNum + "\n");
                if (queries == 0) {
                    break;
                }
            }
            periods.addAll(resto);
            ordem.clear();
            resto.clear();
            actual++;
        }
        saida.flush();
    }
}

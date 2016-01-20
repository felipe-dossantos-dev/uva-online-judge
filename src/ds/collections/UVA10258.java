package ds.collections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class UVA10258 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int qtdTestes = Integer.parseInt(entrada.readLine());
        for (int i = 0; i < qtdTestes; i++) {
            Contest participantes[] = new Contest[101];
            for (int j = 0; j <= 100; j++) {
                participantes[j] = new Contest();
            }
            String linha = entrada.readLine();
            if (i == 0) {
                linha = entrada.readLine();
            }
            while (linha != null && !linha.isEmpty()) {
                String vet[] = linha.split(" ");
                int contestant = Integer.parseInt(vet[0]);
                int problem = Integer.parseInt(vet[1]);
                int time = Integer.parseInt(vet[2]);
                participantes[contestant].contestant = contestant;
                participantes[contestant].participate = true;
                if (vet[3].contains("C") && !participantes[contestant].accepts[problem]) {
                    participantes[contestant].problemsSolved++;
                    participantes[contestant].timePenalty
                            += participantes[contestant].wrongAnswers[problem] + time;
                    participantes[contestant].accepts[problem] = true;
                } else if (vet[3].contains("I")) {
                    participantes[contestant].wrongAnswers[problem] += 20;
                }
                linha = entrada.readLine();
            }
            Arrays.sort(participantes);
            for (int j = 0; j < 101; j++) {
                if (participantes[j].participate) {
                    saida.write(String.format("%d %d %d\n", participantes[j].contestant, participantes[j].problemsSolved, participantes[j].timePenalty));
                }
            }
            if (i < qtdTestes - 1) {
                saida.write("\n");
            }
        }
        saida.flush();
    }

    static class Contest implements Comparable<Contest> {

        public int contestant;
        public int problemsSolved;
        public int timePenalty;
        public int wrongAnswers[] = new int[15];
        public boolean accepts[] = new boolean[15];
        public boolean participate = false;

        public Contest() {
        }

        @Override
        public int compareTo(Contest o) {
            if (this.problemsSolved > o.problemsSolved) {
                return -1;
            }
            if (o.problemsSolved > this.problemsSolved) {
                return 1;
            }
            if (this.timePenalty < o.timePenalty) {
                return -1;
            }
            if (o.timePenalty < this.timePenalty) {
                return 1;
            }
            if (this.contestant < o.contestant) {
                return -1;
            }
            if (o.contestant < this.contestant) {
                return 1;
            }
            return 0;
        }
    }
}

package ds.priority.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.PriorityQueue;

public class UVA10954 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int numbers = Integer.parseInt(linha);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (numbers != 0) {
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            for (int i = 0; i < numbers; i++) {
                String num = vet[i];
                int tmp = Integer.parseInt(num);
                queue.add(tmp);
            }
            long total = 0;
            while (!queue.isEmpty()) {
                Integer a = queue.poll();
                Integer b = queue.poll();
                if (b != null) {
                    int c = a + b;
                    total += c;
                    queue.add(c);
                }
            }
            saida.write(total + "\n");
            linha = entrada.readLine();
            numbers = Integer.parseInt(linha);
        }
        saida.flush();
    }
}

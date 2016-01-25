package ds.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Stack;

public class UVA514 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int tamTrem = Integer.parseInt(linha);
        while (tamTrem != 0) {
            linha = entrada.readLine();
            String vet[] = linha.split("\\s+");
            while (vet.length != 1) {
                Stack<Integer> in = new Stack<>();
                Stack<Integer> station = new Stack<>();
                Stack<Integer> out = new Stack<>();
                //logica
                boolean can = true;
                for (int i = 0; i < tamTrem; i++) {
                    int tmp = Integer.parseInt(vet[i]);
                    in.push(tmp);
                }
                while (!in.empty()) {
                    int top = in.pop();
                    while (!station.empty() && station.peek() > top) {
                        out.push(station.pop());
                    }
                    station.push(top);
                }
                while (!station.empty()) {
                    out.push(station.pop());
                }
                for (int i = 1; i < out.size() && can; i++) {
                    if (out.get(i - 1) < out.get(i)) {
                        can = false;
                    }
                }
                if (can) {
                    saida.write("Yes\n");
                } else {
                    saida.write("No\n");
                }
                linha = entrada.readLine();
                vet = linha.split("\\s+");
            }

            linha = entrada.readLine();
            tamTrem = Integer.parseInt(linha);
            saida.write("\n");
        }
        saida.flush();
    }
}

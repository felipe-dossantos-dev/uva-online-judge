package paradigm.completesearch.iterative;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class UVA11242 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        int front = Integer.parseInt(vet[0]);
        while (front != 0) {
            int rear = Integer.parseInt(vet[1]);
            double fronts[] = new double[front];
            double rears[] = new double[rear];
            List<Double> ratios = new ArrayList<Double>();
            List<Double> spreeds = new ArrayList<Double>();
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            for (int i = 0; i < front; i++) {
                fronts[i] = Double.parseDouble(vet[i]);
            }

            linha = entrada.readLine();
            vet = linha.split("\\s+");
            for (int i = 0; i < rear; i++) {
                rears[i] = Double.parseDouble(vet[i]);
            }
            for (int i = 0; i < rears.length; i++) {
                double r = rears[i];
                for (int j = 0; j < fronts.length; j++) {
                    double f = fronts[j];
                    ratios.add(f / r);
                }
            }
            Collections.sort(ratios);
            for (int i = 1; i < ratios.size(); i++) {
                Double r1 = ratios.get(i);
                Double r2 = ratios.get(i - 1);
                spreeds.add(r1 / r2);
            }
            Collections.sort(spreeds, Collections.reverseOrder());
            saida.write(String.format("%.2f\n", spreeds.get(0)));
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            front = Integer.parseInt(vet[0]);
        }
        saida.flush();
    }
}

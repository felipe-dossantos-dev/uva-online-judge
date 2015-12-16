package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10114 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int monthLoan = Integer.parseInt(vet[0]);
        float downPayment = Float.parseFloat(vet[1]);
        float amountLoan = Float.parseFloat(vet[2]);
        int numberDepreciations = Integer.parseInt(vet[3]);
        while (monthLoan > 0) {
            float rateDeps[] = new float[monthLoan + 1];
            float loanValue = amountLoan;
            float monthlyPayment = amountLoan / monthLoan;
            for (int i = 0; i < numberDepreciations; i++) {
                linha = entrada.readLine();
                vet = linha.split(" ");
                int tmp = Integer.parseInt(vet[0]);
                float d = Float.parseFloat(vet[1]);
                for (int j = tmp; j < rateDeps.length; j++) {
                    rateDeps[j] = d;
                }
            }
            float carValue = (amountLoan + downPayment) * (1 - rateDeps[0]);
            //para cada mes
            int mes = 0;
            while (loanValue >= carValue) {
                loanValue -= monthlyPayment;
                mes++;
                carValue *= (1 - rateDeps[mes]);
            }

            if (mes == 1) {
                saida.write(mes + " month");
            } else {
                saida.write(mes + " months");
            }
            saida.newLine();

            linha = entrada.readLine();
            vet = linha.split(" ");
            monthLoan = Integer.parseInt(vet[0]);
            downPayment = Float.parseFloat(vet[1]);
            amountLoan = Float.parseFloat(vet[2]);
            numberDepreciations = Integer.parseInt(vet[3]);
        }
        saida.flush();
    }
}

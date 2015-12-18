package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA573 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));

        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        double alturaParede = Double.parseDouble(vet[0]);
        double distPercDia = Double.parseDouble(vet[1]);
        double distVoltaNoite = Double.parseDouble(vet[2]);
        double fadiga = Double.parseDouble(vet[3]);
        while (alturaParede > 0) {
            fadiga = distPercDia * (fadiga / 100);
            int contDia = 0;
            double alturaAtual = 0;
            while (true) {
                contDia++;
                alturaAtual += distPercDia;

                if (alturaAtual > alturaParede) {
                    break;
                }
                alturaAtual -= distVoltaNoite;
                if (alturaAtual < 0) {
                    break;
                }
                distPercDia -= fadiga;
                if (distPercDia < 0) {
                    distPercDia = 0;
                }
            }
            if (alturaAtual < 0) {
                saida.write("failure on day " + contDia);
            } else {
                saida.write("success on day " + contDia);
            }
            saida.newLine();
            linha = entrada.readLine();
            vet = linha.split(" ");
            alturaParede = Double.parseDouble(vet[0]);
            distPercDia = Double.parseDouble(vet[1]);
            distVoltaNoite = Double.parseDouble(vet[2]);
            fadiga = Double.parseDouble(vet[3]);
        }
        saida.flush();
    }
}

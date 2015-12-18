package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA661 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int numberDevices = Integer.parseInt(vet[0]);
        int operations = Integer.parseInt(vet[1]);
        int maxCapacity = Integer.parseInt(vet[2]);
        int testCase = 1;
        while (numberDevices != 0 && operations != 0 && maxCapacity != 0) {
            int devices[] = new int[numberDevices];
            int maxAmp = -1;
            boolean powerDevs[] = new boolean[numberDevices];
            for (int i = 0; i < numberDevices; i++) {
                linha = entrada.readLine();
                devices[i] = Integer.parseInt(linha);
            }
            int actualCapacity = 0;
            boolean blown = false;
            for (int i = 0; i < operations; i++) {
                linha = entrada.readLine();
                int pos = Integer.parseInt(linha);
                pos--;
                if (!blown) {
                    if (powerDevs[pos]) {
                        actualCapacity -= devices[pos];
                    } else {
                        actualCapacity += devices[pos];
                    }
                    if (actualCapacity > maxCapacity) {
                        blown = true;
                    }
                    if (actualCapacity > maxAmp) {
                        maxAmp = actualCapacity;
                    }
                    powerDevs[pos] = !powerDevs[pos];
                }
            }
            saida.write("Sequence " + testCase);
            saida.newLine();
            if (blown) {
                saida.write("Fuse was blown.");
            } else {
                saida.write("Fuse was not blown.");
                saida.newLine();
                saida.write("Maximal power consumption was " + maxAmp + " amperes.");
            }
            saida.newLine();
            saida.newLine();
            linha = entrada.readLine();
            vet = linha.split(" ");
            numberDevices = Integer.parseInt(vet[0]);
            operations = Integer.parseInt(vet[1]);
            maxCapacity = Integer.parseInt(vet[2]);
            testCase++;
        }
        saida.flush();
    }
}

package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA12554 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        int qtdPessoas = Integer.parseInt(linha);
        String pessoas[] = new String[qtdPessoas];
        String letras[] = {"Happy", "birthday", "to", "you", "Rujia"};
        boolean visitados[] = new boolean[qtdPessoas];
        for (int i = 0; i < qtdPessoas; i++) {
            pessoas[i] = entrada.readLine();
        }
        int passadas = 0;
        while (!visitados[qtdPessoas - 1]) {
            for (int i = 0; i < 16; i++) {
                int posPessoa = (passadas * 16 + i) % qtdPessoas;
                visitados[posPessoa] = true;
                if (i == 11) {
                    saida.write(pessoas[posPessoa] + ": " + letras[4]);
                } else {
                    saida.write(pessoas[posPessoa] + ": " + letras[i % 4]);
                }
                saida.newLine();
            }
            passadas++;
        }
        saida.flush();
    }
}

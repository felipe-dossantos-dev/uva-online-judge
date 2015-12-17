package adhoc.easy.normal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11559 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        while (linha != null) {
            String vet[] = linha.split(" ");
            int numParticipantes = Integer.parseInt(vet[0]);
            int orcamento = Integer.parseInt(vet[1]);
            int hoteis = Integer.parseInt(vet[2]);
            int semanas = Integer.parseInt(vet[3]);
            boolean stayHome = true;
            int menorOrcamento = Integer.MAX_VALUE;
            for (int i = 0; i < hoteis; i++) {
                linha = entrada.readLine();
                int valor = Integer.parseInt(linha);
                linha = entrada.readLine();
                vet = linha.split(" ");
                boolean vagas = false;
                for (int j = 0; j < semanas; j++) {
                    int tmp = Integer.parseInt(vet[j]);
                    if (tmp >= numParticipantes) {
                        vagas = true;
                    }
                }
                int orcamentoAtual = numParticipantes * valor;
                if (vagas
                        && orcamentoAtual <= orcamento
                        && orcamentoAtual <= menorOrcamento) {
                    menorOrcamento = orcamentoAtual;
                    stayHome = false;
                }
            }
            if (stayHome) {
                saida.write("stay home");
            } else {
                saida.write(menorOrcamento + "");
            }
            saida.newLine();
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

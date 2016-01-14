package adhoc.time;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.GregorianCalendar;
import java.util.Locale;

public class UVA893 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        while (!linha.contains("0 0 0 0")) {
            String vet[] = linha.split("\\s+");
            int soma = Integer.parseInt(vet[0]);
            int dia = Integer.parseInt(vet[1]);
            int mes = Integer.parseInt(vet[2]) - 1;
            int ano = Integer.parseInt(vet[3]);
            //mes começa com 0 nessa budega
            GregorianCalendar gc = new GregorianCalendar(ano, mes, dia);
            gc.add(GregorianCalendar.DATE, soma);
            saida.write(String.format("%d %d %d\n", gc.get(GregorianCalendar.DATE),
                    gc.get(GregorianCalendar.MONTH) + 1,
                    gc.get(GregorianCalendar.YEAR)));
            linha = entrada.readLine();
        }
        saida.flush();
    }
}

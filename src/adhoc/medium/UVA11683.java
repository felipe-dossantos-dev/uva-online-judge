package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA11683 {
     public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int altura = Integer.parseInt(vet[0]);
        while (altura != 0) {
            int largura = Integer.parseInt(vet[1]);
            linha = entrada.readLine();
            vet = linha.split(" ");
            int ant = Integer.parseInt(vet[0]);
            int cont = altura - ant;
            for (int i = 1; i < largura; i++) {
                int atual = Integer.parseInt(vet[i]);
                if (atual < ant) {
                    cont += Math.abs(atual - ant);
                }
                ant = atual;
            }
            saida.write(cont + "");
            saida.newLine();
            linha = entrada.readLine();
            vet = linha.split(" ");
            altura = Integer.parseInt(vet[0]);
        }

        saida.flush();
    }
}

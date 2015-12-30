package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt"));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        int caso = Integer.parseInt(entrada.readLine());
        while (caso != -1) {
            int erros = 7;
            String palavra = entrada.readLine();
            boolean acertadas[] = new boolean[palavra.length()];
            String adivinhada = entrada.readLine();
            Set<Character> conj = new HashSet<>();
            Set<Character> conjPal = new HashSet<>();
            for (char c : palavra.toCharArray()) {
                conjPal.add(c);
            }
            boolean venceu = true;
            for (int i = 0; i < adivinhada.length(); i++) {
                char a = adivinhada.charAt(i);
                boolean errou = false;
                for (int j = 0; j < palavra.length(); j++) {
                    char p = palavra.charAt(j);
                    if (a == p) {
                        errou = true;
                        acertadas[j] = true;
                    }
                }
                if (!conj.contains(a) && errou) {
                    erros--;
                    if (erros == 0) {
                        venceu = false;
                        saida.write("You lose.\n");
                    }
                }
                conj.add(a);
            }
            for (boolean acertada : acertadas) {
                if(!acertada) venceu = false;
            }
            if (venceu) {
                saida.write("You win.\n");
            } else if (conj.size() < conjPal.size()) {
                saida.write("You chickened out.\n");
            }
            caso = Integer.parseInt(entrada.readLine());
        }
        saida.flush();
    }
}

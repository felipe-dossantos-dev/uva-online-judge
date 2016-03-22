package paradigm.completesearch.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UVA380 {

    public static List<Call> lista;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));//C:\Users\felipe.santos\Documents\
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));
        int testes = entrada.nextInt();
        int tmp;
        saida.write("CALL FORWARDING OUTPUT\n");
        for (int i = 1; i <= testes; i++) {
            lista = new ArrayList<>();
            for (;;) {
                tmp = entrada.nextInt();
                if (tmp == 0) {
                    break;
                }
                Call c = new Call();
                c.receiver = tmp;
                c.begin = entrada.nextInt();
                c.duration = entrada.nextInt();
                c.pass = entrada.nextInt();
                lista.add(c);
            }

            tmp = entrada.nextInt();
            saida.write("SYSTEM " + i + "\n");
            while (entrada.hasNext() && tmp != 9000) {
                int time = tmp;
                int receiver = entrada.nextInt();
                int rings = backtrack(time, receiver, receiver, 0);
                saida.write(String.format("AT %04d CALL TO %04d RINGS %04d\n", time, receiver, rings));
                tmp = entrada.nextInt();
            }
        }
        saida.write("END OF OUTPUT\n");
        saida.flush();
    }

    public static void leituraSistema(Scanner entrada) {
        lista = new ArrayList<>();
        int tmp = entrada.nextInt();;
        while (tmp != 0) {
            Call c = new Call();
            c.receiver = tmp;
            c.begin = entrada.nextInt();
            c.duration = entrada.nextInt();
            c.pass = entrada.nextInt();
            lista.add(c);
            tmp = entrada.nextInt();
        }
    }

    public static int backtrack(int time, int receiver, int initial, int calls) {
        if (receiver == initial && calls > 0) {
            return 9999;
        } else {
            for (int i = 0; i < lista.size(); i++) {
                Call c = lista.get(i);
                if (c.receiver == receiver
                        && time >= c.begin
                        && time <= c.begin + c.duration) {
                    return backtrack(time, c.pass, initial, ++calls);
                }
            }
            return receiver;
        }
    }

    public static class Call {

        public int receiver;
        public int pass;
        public int begin;
        public int duration;
    }
}

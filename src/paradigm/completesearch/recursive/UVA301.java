package paradigm.completesearch.recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA301 {

    public static int passengerCapacity;
    public static int cityB;
    public static int ticketsOrders;
    public static int tickets[][] = tickets = new int[25][4];//ultimo visitado;
    public static int biggestValue;

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));//C:\Users\felipe.santos\Documents\
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));

        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        passengerCapacity = Integer.parseInt(vet[0]);
        cityB = Integer.parseInt(vet[1]);
        ticketsOrders = Integer.parseInt(vet[2]);
        while (passengerCapacity != 0 && cityB != 0 && ticketsOrders != 0) {
            for (int i = 0; i < ticketsOrders; i++) {
                linha = entrada.readLine();
                vet = linha.split("\\s+");
                int start = Integer.parseInt(vet[0]);
                int end = Integer.parseInt(vet[1]);
                int passengers = Integer.parseInt(vet[2]);
                tickets[i][0] = start;
                tickets[i][1] = end;
                tickets[i][2] = passengers;
                tickets[i][3] = 0;
            }
            biggestValue = -1;
            backtrack(0, 0, 0, 0);
            saida.write(biggestValue + "\n");
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            passengerCapacity = Integer.parseInt(vet[0]);
            cityB = Integer.parseInt(vet[1]);
            ticketsOrders = Integer.parseInt(vet[2]);
        }
        saida.flush();
    }

    public static void backtrack(int station, int passengers, int value, int orders) {
        if (station == cityB && value > biggestValue) {
            biggestValue = value;
        } else if (station < cityB) {
            //não pegar ninguem
            backtrack(station + 1, passengers, value, 0);
            if (orders != 0) {
                for (int i = 0; i < tickets.length; i++) {
                    int[] ticket = tickets[i];
                    if (ticket[1] == station && ticket[3] == 1) {
                        passengers -= ticket[2];
                    }
                }
            }
            //pegar todos
            //posso pegar uma ordem ou varias
            for (int i = orders; i < ticketsOrders; i++) {
                if (tickets[i][0] == station && tickets[i][3] == 0
                        && passengers + tickets[i][2] <= passengerCapacity) {
                    int newValue = value + tickets[i][2] * (tickets[i][1] - tickets[i][0]);
                    tickets[i][3] = 1;
                    backtrack(station, passengers + tickets[i][2], newValue, i);
                    backtrack(station + 1, passengers + tickets[i][2], newValue, 0);
                    tickets[i][3] = 0;
                }
            }
        }
    }
}

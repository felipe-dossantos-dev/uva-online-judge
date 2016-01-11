package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static char[][] A_5 = {{'.', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] B_5 = {{'*', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '.', '.'}};
    public static char[][] C_5 = {{'.', '*', '*', '*', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'.', '*', '*', '*', '*', '.'}};
    public static char[][] D_5 = {{'*', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '.', '.'}};
    public static char[][] E_5 = {{'*', '*', '*', '*', '*', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '*', '*', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '*', '*', '*', '*', '.'}};
    public static char[][] F_5 = {{'*', '*', '*', '*', '*', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '*', '*', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'}};
    public static char[][] G_5 = {{'.', '*', '*', '*', '*', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '.', '.', '*', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'.', '*', '*', '*', '.', '.'}};
    public static char[][] H_5 = {{'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] I_5 = {{'*', '*', '*', '*', '*', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'*', '*', '*', '*', '*', '.'}};
    public static char[][] J_5 = {{'.', '.', '*', '*', '*', '.'},
    {'.', '.', '.', '*', '.', '.'},
    {'.', '.', '.', '*', '.', '.'},
    {'*', '.', '.', '*', '.', '.'},
    {'.', '*', '*', '.', '.', '.'}};
    public static char[][] K_5 = {{'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '*', '.', '.'},
    {'*', '*', '*', '.', '.', '.'},
    {'*', '.', '.', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] L_5 = {{'*', '.', '.', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '*', '*', '*', '*', '.'}};
    public static char[][] M_5 = {{'*', '.', '.', '.', '*', '.'},
    {'*', '*', '.', '*', '*', '.'},
    {'*', '.', '*', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] N_5 = {{'*', '.', '.', '.', '*', '.'},
    {'*', '*', '.', '.', '*', '.'},
    {'*', '.', '*', '.', '*', '.'},
    {'*', '.', '.', '*', '*', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] O_5 = {{'.', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'.', '*', '*', '*', '.', '.'}};
    public static char[][] P_5 = {{'*', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'*', '.', '.', '.', '.', '.'}};
    public static char[][] Q_5 = {{'.', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '*', '*', '.'},
    {'.', '*', '*', '*', '*', '.'}};
    public static char[][] R_5 = {{'*', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '.', '.'},
    {'*', '.', '.', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] S_5 = {{'.', '*', '*', '*', '*', '.'},
    {'*', '.', '.', '.', '.', '.'},
    {'.', '*', '*', '*', '.', '.'},
    {'.', '.', '.', '.', '*', '.'},
    {'*', '*', '*', '*', '.', '.'}};
    public static char[][] T_5 = {{'*', '*', '*', '*', '*', '.'},
    {'*', '.', '*', '.', '*', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '*', '*', '*', '.', '.'}};
    public static char[][] U_5 = {{'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'.', '*', '*', '*', '.', '.'}};
    public static char[][] V_5 = {{'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'.', '*', '.', '*', '.', '.'},
    {'.', '*', '.', '*', '.', '.'},
    {'.', '.', '*', '.', '.', '.'}};
    public static char[][] W_5 = {{'*', '.', '.', '.', '*', '.'},
    {'*', '.', '.', '.', '*', '.'},
    {'*', '.', '*', '.', '*', '.'},
    {'*', '*', '.', '*', '*', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] X_5 = {{'*', '.', '.', '.', '*', '.'},
    {'.', '*', '.', '*', '.', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '*', '.', '*', '.', '.'},
    {'*', '.', '.', '.', '*', '.'}};
    public static char[][] Y_5 = {{'*', '.', '.', '.', '*', '.'},
    {'.', '*', '.', '*', '.', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '.', '*', '.', '.', '.'}};
    public static char[][] Z_5 = {{'*', '*', '*', '*', '*', '.'},
    {'.', '.', '.', '*', '.', '.'},
    {'.', '.', '*', '.', '.', '.'},
    {'.', '*', '.', '.', '.', '.'},
    {'*', '*', '*', '*', '*', '.'}};
    public static char[][] ESP_5 = {{'.', '.', '.', '.', '.', '.'},
    {'.', '.', '.', '.', '.', '.'},
    {'.', '.', '.', '.', '.', '.'},
    {'.', '.', '.', '.', '.', '.'},
    {'.', '.', '.', '.', '.', '.'}};

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\felipe.santos\\Documents\\entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));
//        Scanner entrada = new Scanner(new FileInputStream(args[0]));
//        Scanner entrada = new Scanner(System.in);
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\felipe.santos\\Documents\\saidas.txt")));
        String linha = entrada.readLine();
        char pag[][] = new char[60][60];
        for (int i = 0; i < 60; i++) {
            Arrays.fill(pag[i], '.');
        }
        while (!linha.equals(".EOP")) {
            String vet[] = linha.split("\\s+");
            String cmd = vet[0];
            int font;
            int row;
            int col;
            String text;
            if (cmd.equals(".P")) {
                font = Integer.parseInt(vet[1].replaceAll("C", ""));
                row = Integer.parseInt(vet[2]);
                col = Integer.parseInt(vet[3]);

            }
            linha = entrada.readLine();
        }
        //printar pagina
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                saida.write(pag[i][j]);
            }
            saida.write("\n");
        }
        saida.write("\n");
        for (int i = 0; i < 60; i++) {
            saida.write('.');
        }
        saida.write("\n");
        saida.flush();
    }

    public static void printC1(char[][] matriz, int row, int col, String str) {
        int size = str.length();
        int matrizLen = matriz[0].length;
        for (int i = 0; i < size && col + i < matrizLen; i++) {
            matriz[row][col + i] = str.charAt(i);
        }
    }

    public static void printC5(char[][] matriz, int row, int col, String str) {
        int size = str.length();
        int matrizLen = matriz[0].length;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            char atual = str.charAt(i);
            char[][] c5 = getCharC5(atual);
            for (int l = 0; l < 5; l++) {
                for (int c = 0; c < 6; c++) {
                    
                }
            }
        }
    }

    private static char[][] getCharC5(char atual) {
        switch (atual) {
            case 'A':
                return A_5;
            case 'B':
                return B_5;
            case 'C':
                return C_5;
            case 'D':
                return D_5;
            case 'E':
                return E_5;
            case 'F':
                return F_5;
            case 'G':
                return G_5;
            case 'H':
                return H_5;
            case 'I':
                return I_5;
            case 'J':
                return J_5;
            case 'L':
                return L_5;
            case 'M':
                return M_5;
            case 'N':
                return N_5;
            case 'O':
                return O_5;
            case 'P':
                return P_5;
            case 'K':
                return K_5;
            case 'Q':
                return Q_5;
            case 'R':
                return R_5;
            case 'T':
                return T_5;
            case 'U':
                return U_5;
            case 'V':
                return V_5;
            case 'X':
                return X_5;
            case 'Z':
                return Z_5;
            case 'Y':
                return Y_5;
            case 'W':
                return W_5;
            default:
                return ESP_5;
        }
    }
}

package ds.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10920 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split("\\s+");
        int size = Integer.parseInt(vet[0]);
        int position = Integer.parseInt(vet[1]);
        while (size != 0 && position != 0) {
            int value = 1;
            int sqrt = 1;
            while (Math.pow(sqrt + 2, 2) <= position && sqrt <= size) {
                value++;
                sqrt += 2;
            }
            int posY = value + size / 2;
            int posX = value + size / 2;
            // <= >=
            int xMax = posX + 1;
            int yMax = posY + 1;
            int xMin = size - posX;
            int yMin = size - posY;
            int distLeft = posX - xMin;
            int distDown = posY - yMin + 1;
            int distRight = xMax - xMin;
            int distUp = yMax - yMin;
            if (Math.pow(sqrt, 2) > position) {
                sqrt -= 2;
            }
            value = sqrt * sqrt;
            if (value != position) {
                value++;
                posY++;
                if (value + distLeft >= position) {
                    posX -= position - value;
                } else {
                    value += distLeft;
                    posX = xMin;
                    if (value + distDown >= position) {
                        posY -= position - value;
                    } else {
                        posY = yMin;
                        value += distDown;
                        if (value + distRight >= position) {
                            posX += position - value;
                        } else {
                            posX = xMax;
                            value += distRight;
                            if (value + distUp >= position) {
                                posY += position - value;
                            }
                        }
                    }
                }
            }
            saida.write(String.format("Line = %d, column = %d.\n", posY, posX));
            linha = entrada.readLine();
            vet = linha.split("\\s+");
            size = Integer.parseInt(vet[0]);
            position = Integer.parseInt(vet[1]);
        }
        saida.flush();
    }
}

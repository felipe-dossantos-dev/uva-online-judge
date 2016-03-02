package paradigm.completesearch.iterative;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UVA01047 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        int towersPlanned = entrada.nextInt();
        int towersBuilt = entrada.nextInt();
        int caso = 1;
        while (towersBuilt != 0 && towersPlanned != 0) {

            int planneds[] = new int[towersPlanned];
            for (int i = 0; i < towersPlanned; i++) {
                planneds[i] = entrada.nextInt();
            }

            int commonAreas = entrada.nextInt();
            List<CommonArea> areas = new ArrayList<>();
            for (int i = 0; i < commonAreas; i++) {
                CommonArea ca = new CommonArea();
                int numberAreas = entrada.nextInt();
                for (int j = 0; j < numberAreas; j++) {
                    ca.areas.add(entrada.nextInt() - 1);
                }
                ca.value = entrada.nextInt();
                areas.add(ca);
            }

            int max = -1;
            List<Integer> indexForMax = null;

            for (int i = 1 << towersPlanned; i >= 0; i--) {
                List<Integer> subs = new ArrayList<>();
                for (int j = 0; j < planneds.length; j++) {
                    if ((i & (1 << j)) != 0) {
                        subs.add(j);
                    }
                }
                if (subs.size() == towersBuilt) {
                    int sum = 0;
                    for (int j = 0; j < subs.size(); j++) {
                        int index = subs.get(j);
                        sum += planneds[index];
                    }
                    for (CommonArea area : areas) {
                        int cont = 0;
                        for (int j = 0; j < area.areas.size(); j++) {
                            int index = area.areas.get(j);
                            if (subs.contains(index)) {
                                cont++;
                            }
                        }
                        if (cont > 1) {
                            sum -= (cont - 1) * area.value;
                        }
                    }
                    Collections.sort(subs);
                    if (sum >= max) {
                        max = sum;
                        boolean maior = true;
                        if (sum == max && indexForMax != null) {
                            for (int j = 0; j < subs.size() && maior; j++) {
                                maior = maior && subs.get(j) <= indexForMax.get(j);
                            }
                        }
                        if (maior) {
                            indexForMax = subs;
                        }
                    }
                }
            }
            saida.write("Case Number  " + caso + "\n");
            saida.write("Number of Customers: " + max + "\n");
            saida.write("Locations recommended: ");
            for (int i = 0; i < indexForMax.size(); i++) {
                Integer j = indexForMax.get(i);
                saida.write((j + 1) + "");
                if (i != indexForMax.size() - 1) {
                    saida.write(" ");
                }
            }
            saida.write("\n\n");

            towersPlanned = entrada.nextInt();
            towersBuilt = entrada.nextInt();
            caso++;
        }
        saida.flush();
    }

    public static class CommonArea {

        public List<Integer> areas;
        public int value;

        public CommonArea() {
            areas = new ArrayList<>();
            value = 0;
        }
    }
}

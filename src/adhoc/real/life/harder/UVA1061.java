package adhoc.real.life.harder;

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

public class UVA1061 {

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
        int caso = 1;
        while (!linha.contains("E N D")) {
            String vet[] = linha.split("\\s+");
            if (!linha.isEmpty() && vet.length == 3) {
                int posTem = 1;
                boolean father = true;
                if (vet[1].contains("?")) {
                    posTem = 0;
                } else if (vet[2].contains("?")) {
                    father = false;
                }
                boolean onlyNegativeRh;
                if (father) {
                    onlyNegativeRh = false;
                } else {
                    onlyNegativeRh = vet[0].contains("-") && vet[1].contains("-");
                }
                saida.write("Case " + caso + ": ");
                //alelos
                if (father) {
                    if (posTem == 0) {
                        saida.write(vet[0] + " ");
                    }
                    String p = alleleType(vet[posTem]);
                    String son = alleleType(vet[2]);
                    Set<String> conj = new HashSet<>();
                    if (son.contains("AB") && !vet[posTem].contains("O")) {
                        conj.add("AB");
                    }
                    for (int i = 0; i < 2; i++) {
                        String str = son.replace(p.subSequence(i, i + 1), "");
                        if (str.length() == 1) {
                            conj.add(str);
                        } else if (str.isEmpty() && son.contains("O")) {
                            conj.add("A");
                            conj.add("B");
                            conj.add("O");
                        }
                    }
                    if (conj.isEmpty()) {
                        saida.write("IMPOSSIBLE");
                    } else {
                        saida.write("{");
                        String[] valores = conj.toArray(new String[]{});
                        for (int i = 0; i < valores.length; i++) {
                            String tmp = valores[i];
                            if (!tmp.isEmpty()) {
                                if (!onlyNegativeRh) {
                                    saida.write(tmp + "+, ");
                                }
                                saida.write(tmp + "-");
                                if (i != valores.length - 1) {
                                    saida.write(", ");
                                }
                            }
                        }
                        saida.write("}");
                    }
                    if (posTem == 1) {
                        saida.write(" " + vet[1]);
                    }
                    saida.write(" " + vet[2]);
                } else {
                    saida.write(vet[0] + " " + vet[1] + " {");
                    String p1 = alleleType(vet[0]);
                    String p2 = alleleType(vet[1]);
                    Set<String> conj = new HashSet<>();
                    String p1s = vet[0].replaceAll("[\\+\\-]", "");
                    String p2s = vet[1].replaceAll("[\\+\\-]", "");
                    if ((p1s.equals("A") && p2s.equals("B"))
                            || (p1s.equals("B") && p2s.equals("A"))
                            || (p1s.equals("AB") && !p2s.equals("O"))
                            || (!p1s.equals("O") && p2s.equals("AB"))) {
                        conj.add("AB");
                    }
                    for (int i = 0; i < p1.length(); i++) {
                        for (int j = 0; j < p2.length(); j++) {
                            String str = p1.substring(i, i + 1) + p2.substring(j, j + 1);
                            conj.add(bloodType(str));
                        }
                    }
                    String[] valores = conj.toArray(new String[]{});
                    for (int i = 0; i < valores.length; i++) {
                        String tmp = valores[i];
                        if (!tmp.isEmpty()) {
                            if (!onlyNegativeRh) {
                                saida.write(tmp + "+, ");
                            }
                            saida.write(tmp + "-");
                            if (i != valores.length - 1) {
                                saida.write(", ");
                            }
                        }
                    }
                    saida.write("}");
                }
                saida.write("\n");
                caso++;
            }
            linha = entrada.readLine();
        }
        saida.flush();
    }

    public static String alleleType(String blood) {
        if (blood.contains("AB")) {
            return "AB";
        } else if (blood.contains("A")) {
            return "AO";
        } else if (blood.contains("B")) {
            return "BO";
        } else if (blood.contains("O")) {
            return "OO";
        }
        return "";
    }

    public static String bloodType(String allele) {
        if (allele.contains("AB")) {
            return "AB";
        } else if (allele.contains("AO")
                || allele.contains("OA")
                || allele.contains("AA")) {
            return "A";
        } else if (allele.contains("BO")
                || allele.contains("OB")
                || allele.contains("BB")) {
            return "B";
        } else if (allele.contains("OO")) {
            return "O";
        }
        return "";
    }
}

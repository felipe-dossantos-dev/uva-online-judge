package adhoc.time;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.GregorianCalendar;
import java.util.Locale;

public class UVA11947 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
        String linha = entrada.readLine();
        int qtdTestes = Integer.parseInt(linha);
        for (int i = 1; i <= qtdTestes; i++) {
            linha = entrada.readLine();
            int dia = Integer.parseInt(linha.substring(2, 4));
            int mes = Integer.parseInt(linha.substring(0, 2)) - 1;
            int ano = Integer.parseInt(linha.substring(4, 8));
            GregorianCalendar gc = new GregorianCalendar(ano, mes, dia);
            gc.add(GregorianCalendar.WEEK_OF_YEAR, 40);
            String sign = "";
            int day = gc.get(GregorianCalendar.DATE);
            int month = gc.get(GregorianCalendar.MONTH);
            switch (month) {
                case GregorianCalendar.JANUARY:
                    if (day < 21) {
                        sign = "capricorn";
                    } else {
                        sign = "aquarius";
                    }
                    break;
                case GregorianCalendar.FEBRUARY:
                    if (day < 20) {
                        sign = "aquarius";
                    } else {
                        sign = "pisces";
                    }
                    break;
                case GregorianCalendar.MARCH:
                    if (day < 21) {
                        sign = "pisces";
                    } else {
                        sign = "aries";
                    }
                    break;
                case GregorianCalendar.APRIL:
                    if (day < 21) {
                        sign = "aries";
                    } else {
                        sign = "taurus";
                    }
                    break;
                case GregorianCalendar.MAY:
                    if (day < 22) {
                        sign = "taurus";
                    } else {
                        sign = "gemini";
                    }
                    break;
                case GregorianCalendar.JUNE:
                    if (day < 22) {
                        sign = "gemini";
                    } else {
                        sign = "cancer";
                    }
                    break;
                case GregorianCalendar.JULY:
                    if (day < 23) {
                        sign = "cancer";
                    } else {
                        sign = "leo";
                    }
                    break;
                case GregorianCalendar.AUGUST:
                    if (day < 22) {
                        sign = "leo";
                    } else {
                        sign = "virgo";
                    }
                    break;
                case GregorianCalendar.SEPTEMBER:
                    if (day < 24) {
                        sign = "virgo";
                    } else {
                        sign = "libra";
                    }
                    break;
                case GregorianCalendar.OCTOBER:
                    if (day < 24) {
                        sign = "libra";
                    } else {
                        sign = "scorpio";
                    }
                    break;
                case GregorianCalendar.NOVEMBER:
                    if (day < 23) {
                        sign = "scorpio";
                    } else {
                        sign = "sagittarius";
                    }
                    break;
                case GregorianCalendar.DECEMBER:
                    if (day < 23) {
                        sign = "sagittarius";
                    } else {
                        sign = "capricorn";
                    }
                    break;
                default:
                    sign = "";
            }
            saida.write(i + " " + String.format("%02d/%02d/%d ", gc.get(GregorianCalendar.MONTH) + 1,
                    gc.get(GregorianCalendar.DATE),
                    gc.get(GregorianCalendar.YEAR)) + sign + "\n");
        }
        saida.flush();
    }
}

package adhoc.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UVA10919 {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
        String linha = entrada.readLine();
        String vet[] = linha.split(" ");
        int courses = Integer.parseInt(vet[0]);
        while (courses != 0) {
            String doneCourses[] = new String[courses];
            int categories = Integer.parseInt(vet[1]);
            while (courses != 0) {
                linha = entrada.readLine();
                vet = linha.split(" ");
                for (String s : vet) {
                    doneCourses[--courses] = s;
                }
            }
            boolean done = true;
            for (int i = 0; i < categories; i++) {
                linha = entrada.readLine();
                vet = linha.split(" ");
                int coursesInCat = Integer.parseInt(vet[0]);
                int minCourses = Integer.parseInt(vet[1]);
                for (int j = 2; j < coursesInCat + 2; j++) {
                    String actCourse = vet[j];
                    for (String doneCourse : doneCourses) {
                        if (doneCourse.equals(actCourse)) {
                            minCourses--;
                        }
                    }
                }
                if (minCourses > 0) {
                    done = false;
                }
            }
            if (done) {
                saida.write("yes");
            } else {
                saida.write("no");
            }
            saida.newLine();

            linha = entrada.readLine();
            vet = linha.split(" ");
            courses = Integer.parseInt(vet[0]);
        }
        saida.flush();
    }
}

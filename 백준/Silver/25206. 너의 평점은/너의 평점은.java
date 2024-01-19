import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double grades = 0;  // 학점 총합
        double majors = 0;  // 전공과목 합
        int n = 20;
        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String rating = st.nextToken();

            switch (rating){
                case "A+" :
                    majors += (4.5 * score);
                    grades += score;
                    break;
                case "A0":
                    majors += (4.0 * score);
                    grades += score;
                    break;
                case "B+":
                    majors += (3.5 * score);
                    grades += score;
                    break;
                case "B0":
                    majors += (3.0 * score);
                    grades += score;
                    break;
                case "C+":
                    majors += (2.5 * score);
                    grades += score;
                    break;
                case "C0":
                    majors += (2.0 * score);
                    grades += score;
                    break;
                case "D+":
                    majors += (1.5 * score);
                    grades += score;
                    break;
                case "D0":
                    majors += (1.0 * score);
                    grades += score;
                    break;
                case "F":
                    majors += (0.0 * score);
                    grades += score;
//                    grades -= score;
                    break;
            }
        }
//        if (Double.isNaN(majors/grades)) System.out.println("0.000000");
        System.out.printf("%.6f", (majors / grades));
    }
}
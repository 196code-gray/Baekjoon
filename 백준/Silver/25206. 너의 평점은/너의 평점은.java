import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subject = 20;
        double sum, ans; sum = ans = 0;
        while (subject --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken()); // 학점
            String rank = st.nextToken(); // 가목평점
            sum += score;
            double n = 0;
            switch (rank){
                case "A+" :
                    n = score * 4.5;
                    ans += n;
                    break;
                case "A0":
                    n = score * 4.0;
                    ans += n;
                    break;
                case "B+":
                    n = score * 3.5;
                    ans += n;
                    break;
                case "B0":
                    n = score * 3.0;
                    ans += n;
                    break;
                case "C+":
                    n = score * 2.5;
                    ans += n;
                    break;
                case "C0":
                    n = score * 2.0;
                    ans += n;
                    break;
                case "D+":
                    n = score * 1.5;
                    ans += n;
                    break;
                case "D0":
                    n = score * 1.0;
                    ans += n;
                    break;
                case "F":
                    n = score * 0.0;
                    ans += n;
                    break;
                case "P":
                    sum -= score;
            }
        }
        System.out.println(ans / sum);
    }
}
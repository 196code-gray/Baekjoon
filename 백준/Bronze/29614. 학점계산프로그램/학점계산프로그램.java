import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int ap, a, bp, b, cp, c, dp, d, f;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ap = (s.length() - s.replace("A+", "").length()) / 2;
        s = s.replace("A+", "");
        a = s.length() - s.replace("A", "").length();
        s = s.replace("A", "");
        bp = (s.length() - s.replace("B+", "").length()) / 2;
        s = s.replace("B+", "");
        b = s.length() - s.replace("B", "").length();
        s = s.replace("B", "");
        cp = (s.length() - s.replace("C+", "").length()) / 2;
        s = s.replace("C+", "");
        c = s.length() - s.replace("C", "").length();
        s = s.replace("C", "");
        dp = (s.length() - s.replace("D+", "").length()) / 2;
        s = s.replace("D+", "");
        d = s.length() - s.replace("D", "").length();
        s = s.replace("D", "");
        f = s.length() - s.replace("F", "").length();

        double ans = ((ap * 4.5) + (a * 4.0) + (bp * 3.5) + (b * 3.0) + (cp * 2.5) + (c * 2.0) +
                (dp * 1.5) + (d * 1.0) + (f * 0.0)) / (ap + a + bp + b + cp + c + dp + d + f);

        System.out.println(ans);
    }
}

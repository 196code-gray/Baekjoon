import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int basic = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int d_input = Integer.parseInt(st.nextToken());
        int d_output = Integer.parseInt(st.nextToken());

        int w1 = w;
        int w2 = w;

        int basic2 = basic;

        for (int i = 0; i < day; i++) {
            w1 += d_input - (basic + d_output);
            w2 += d_input - (basic2 + d_output);

            if (Math.abs(d_input - (basic2 + d_output)) > t) {
                basic2 += Math.floor((d_input - (basic2 + d_output)) / 2.0);
            }
        }

        if (w1 <= 0) {
            System.out.println("Danger Diet");
        } else {
            System.out.println(w1 + " " + basic);
        }

        if (w2 <= 0 || basic2 <= 0) {
            System.out.println("Danger Diet");
        } else {
            System.out.print(w2 + " " + basic2 + " ");
            if (basic - basic2 > 0) {
                System.out.println("YOYO");
            } else {
                System.out.println("NO");
            }
        }
    }
}
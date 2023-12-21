import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println("1" + " " + "0");
                continue;
            }
            if (n == 1) {
                System.out.println("0" + " " + "1");
                continue;
            }
            int[][] fibo = new int[n + 1][2];
            fibo[0][0] = 1;
            fibo[0][1] = 0;
            fibo[1][0] = 0;
            fibo[1][1] = 1;

            for (int i = 2; i <= n; i++) {
                fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
                fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
            }
            System.out.println(fibo[n][0] + " " + fibo[n][1]);
        }
    }
}
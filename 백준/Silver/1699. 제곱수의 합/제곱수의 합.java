import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2){
            System.out.println(2);
            return;
        }
        for (int i = 1; i<=n; i++) dp[i] = i;

        for (int i = 2; i<= Math.sqrt(n);i++){
            for (int j =i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
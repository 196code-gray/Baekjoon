import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        final int mod = 1_000_000_007;

        long[] dp = new long[5001];
        dp[0] = 1; dp[2] = 1; dp[4] = 2;

        for (int i = 6; i <= 5000; i += 2){
            for (int j = 2; j <= i; j += 2){
                dp[i] += dp[j -2] * dp[i - j];
                dp[i] %= mod;
            }
        }
        while (t --> 0) {
            int len = Integer.parseInt(br.readLine());
            System.out.println(dp[len] % mod);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 동전
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1_000_000); dp[0] = 0;
        for (int i = 1; i <= n;i++){
            if (i - 2 >= 0) dp[i] = Math.min(dp[i -2] +1, dp[i]);
            if (i - 5 >= 0) dp[i] = Math.min(dp[i -5] +1, dp[i]);
        }
        System.out.println((dp[n] == 1_000_000) ? -1 : dp[n]);
    }
}
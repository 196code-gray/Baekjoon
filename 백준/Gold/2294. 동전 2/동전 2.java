import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] dp = new long[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = num; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }

        System.out.println((dp[k] == Integer.MAX_VALUE) ? -1 : dp[k]);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws Exception{
        final int MXN = 10000;
        int[][] dp = new int[MXN + 1][2];
        int a = 1, b = 2, n;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= n; i++) dp[i][0] = 1000000000;
        
        while (b <= n) {
            for (int i = b; i <= n; i++) {
                dp[i][0] = Math.min(dp[i][0], dp[i - b][0] + a);
                dp[i][1] = Math.max(dp[i][1], dp[i - b][1] + a);
            }
            b += a;
            a = b - a;
        }
        
        System.out.printf("%d %d", dp[n][0], dp[n][1]);
    }
}

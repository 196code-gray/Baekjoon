import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); int m = Integer.parseInt(br.readLine());
        long dp[] = new long[n + 1];
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        long ans = 1, vip = 0;
        for (int i = 0; i < m; i++){
            int now = Integer.parseInt(br.readLine());
            ans *= dp[(int) (now - vip -1)];
            vip = now;
        }
        ans *= dp[(int) (n - vip)];
        System.out.println(ans);
    }
}
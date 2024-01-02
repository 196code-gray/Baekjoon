import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        if (n == 1){
            System.out.println(10);
            return;
        }
        if (n == 2) {
            System.out.println(55);
            return;
        }
        dp[1][0] = dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = dp[1][6] = dp[1][7] = dp[1][8] = dp[1][9] = 1;
        dp[2][0] = 1; dp[2][1] = 2; dp[2][2] = 3; dp[2][3] = 4; dp[2][4] = 5; dp[2][5] = 6; dp[2][6] = 7; dp[2][7] = 8; dp[2][8] = 9; dp[2][9] = 10;
        for (int i = 3; i <= n;i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) dp[i][0] = 1;
                else dp[i][j] = dp[i -1][j] + dp[i][j -1];
                dp[i][j] %= 10007;
            }
        }
        long ans = 0;
        for (long i : dp[n]) {
            ans += i;
        }
        System.out.println(ans % 10007);
    }
}
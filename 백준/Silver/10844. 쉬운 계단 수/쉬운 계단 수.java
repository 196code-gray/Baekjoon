import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        if (n == 1) {
            System.out.println(9);
            return;
        }
        dp[1][1] = 1; dp[1][2] = 1; dp[1][3] = 1; dp[1][4] = 1; dp[1][5] = 1; dp[1][6] = 1; dp[1][7] = 1;
        dp[1][8] = 1; dp[1][9] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 0; j <= 9; j++){
                if (j == 9) dp[i][9] = (dp[i -1][8]) % 1_000_000_000;
                else if (j == 0) dp[i][0] = (dp[i -1][1]) % 1_000_000_000;
                else {
                    dp[i][j] = (dp[i -1][j -1] + dp[i -1][j + 1]) % 1_000_000_000;
                }
            }
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] + dp[n][5] + dp[n][6] + dp[n][7] + dp[n][8] + dp[n][9]) % 1_000_000_000);
    }
}